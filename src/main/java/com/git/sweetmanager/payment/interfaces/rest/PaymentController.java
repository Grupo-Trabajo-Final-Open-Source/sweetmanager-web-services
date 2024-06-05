package com.git.sweetmanager.payment.interfaces.rest;

import com.git.sweetmanager.payment.domain.model.commands.payment.CreatePaymentCommand;
import com.git.sweetmanager.payment.domain.model.queries.payment.GetAllPaymentsQuery;
import com.git.sweetmanager.payment.domain.model.queries.payment.GetPaymentByIdQuery;
import com.git.sweetmanager.payment.domain.services.payment.PaymentCommandService;
import com.git.sweetmanager.payment.domain.services.payment.PaymentQueryService;
import com.git.sweetmanager.payment.interfaces.rest.resources.payment.CreatePaymentResource;
import com.git.sweetmanager.payment.interfaces.rest.resources.payment.PaymentResource;
import com.git.sweetmanager.payment.interfaces.rest.transform.payment.CreatePaymentCommandFromResourceAssembler;
import com.git.sweetmanager.payment.interfaces.rest.transform.payment.PaymentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/payments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Payments", description = "Payments Management Endpoints")
public class PaymentController {
    private final PaymentQueryService paymentQueryService;

    private final PaymentCommandService paymentCommandService;

    public PaymentController(PaymentQueryService paymentQueryService, PaymentCommandService paymentCommandService) {
        this.paymentQueryService = paymentQueryService;
        this.paymentCommandService = paymentCommandService;
    }

    @PostMapping
    public ResponseEntity<PaymentResource> createPayment(@RequestBody CreatePaymentCommand resource){
        var createPaymentCommand = CreatePaymentCommandFromResourceAssembler.toCommandFromResource(resource);

        var payment = paymentCommandService.handle(createPaymentCommand);

        if(payment.isEmpty()) return ResponseEntity.badRequest().build();

        var paymentResource = PaymentResourceFromEntityAssembler.toResourceFromEntity(payment.get());

        return new ResponseEntity<>(paymentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResource> getPayment(@PathVariable Long paymentId){

       var getPaymentByIdQuery = new GetPaymentByIdQuery(paymentId);

       var payment = paymentQueryService.handle(getPaymentByIdQuery);

       if(payment.isEmpty()) return ResponseEntity.badRequest().build();

       var paymentResource = PaymentResourceFromEntityAssembler.toResourceFromEntity(payment.get());

       return new ResponseEntity<>(paymentResource, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PaymentResource>> getAllPayments(){

        var getAllPaymentsQuery = new GetAllPaymentsQuery();

        var payments = paymentQueryService.handle(getAllPaymentsQuery);

        var paymentResources = payments.stream()
                .map(PaymentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return new ResponseEntity<>(paymentResources, HttpStatus.OK);
    }
}
