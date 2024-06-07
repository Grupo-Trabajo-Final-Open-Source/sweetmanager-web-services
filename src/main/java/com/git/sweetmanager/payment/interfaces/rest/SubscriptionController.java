package com.git.sweetmanager.payment.interfaces.rest;

import com.git.sweetmanager.payment.domain.model.commands.subscription.CreateSubscriptionCommand;
import com.git.sweetmanager.payment.domain.model.queries.subscription.GetAllSubscriptionsQuery;
import com.git.sweetmanager.payment.domain.model.queries.subscription.GetSubscriptionByIdQuery;
import com.git.sweetmanager.payment.domain.services.subscription.SubscriptionCommandService;
import com.git.sweetmanager.payment.domain.services.subscription.SubscriptionQueryService;
import com.git.sweetmanager.payment.interfaces.rest.resources.subscription.SubscriptionResource;
import com.git.sweetmanager.payment.interfaces.rest.transform.subscription.CreateSubscriptionCommandFromResourceAssembler;
import com.git.sweetmanager.payment.interfaces.rest.transform.subscription.SubscriptionResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/subscriptions", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Subscriptions", description = "Subscription Management Endpoints")
public class SubscriptionController {
    private final SubscriptionQueryService subscriptionQueryService;

    private final SubscriptionCommandService subscriptionCommandService;

    public SubscriptionController(SubscriptionQueryService subscriptionQueryService, SubscriptionCommandService subscriptionCommandService) {
        this.subscriptionQueryService = subscriptionQueryService;
        this.subscriptionCommandService = subscriptionCommandService;
    }

    @PostMapping
    public ResponseEntity<SubscriptionResource> createSubscription(@RequestBody CreateSubscriptionCommand resource) {
        var createSubscriptionCommand = CreateSubscriptionCommandFromResourceAssembler.toCommandFromResource(resource);

        var subscription = subscriptionCommandService.handle(createSubscriptionCommand);

        if(subscription.isEmpty()) return ResponseEntity.badRequest().build();

        var subscriptionResource = SubscriptionResourceFromEntityAssembler.toResourceFromEntity(subscription.get());

        return new ResponseEntity<>(subscriptionResource, HttpStatus.CREATED);
    }

    @GetMapping("/{subscriptionId}")
    public ResponseEntity<SubscriptionResource> getSubscriptionById(@PathVariable Long subscriptionId) {
        var getSubscriptionByIdQuery = new GetSubscriptionByIdQuery(subscriptionId);

        var subscription = subscriptionQueryService.handle(getSubscriptionByIdQuery);

        if(subscription.isEmpty()) return ResponseEntity.badRequest().build();

        var subscriptionResource = SubscriptionResourceFromEntityAssembler.toResourceFromEntity(subscription.get());

        return new ResponseEntity<>(subscriptionResource, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<SubscriptionResource>> getAllSubscriptions() {
        var getAllSubscriptionsQuery = new GetAllSubscriptionsQuery();

        var subscriptions = subscriptionQueryService.handle(getAllSubscriptionsQuery);

        var subscriptionResources = subscriptions.stream()
                .map(SubscriptionResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(subscriptionResources);
    }

}
