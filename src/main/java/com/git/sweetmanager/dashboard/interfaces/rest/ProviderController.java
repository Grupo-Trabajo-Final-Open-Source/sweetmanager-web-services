package com.git.sweetmanager.dashboard.interfaces.rest;

import com.git.sweetmanager.dashboard.domain.model.queries.provider.GetAllProvidersQuery;
import com.git.sweetmanager.dashboard.domain.model.queries.provider.GetProviderByIdQuery;
import com.git.sweetmanager.dashboard.domain.services.provider.ProviderCommandService;
import com.git.sweetmanager.dashboard.domain.services.provider.ProviderQueryService;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.provider.CreateProviderResource;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.provider.ProviderResource;
import com.git.sweetmanager.dashboard.interfaces.rest.transform.provider.CreateProviderCommandFromResourceAssembler;
import com.git.sweetmanager.dashboard.interfaces.rest.transform.provider.ProviderResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/providers", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProviderController {
    private final ProviderQueryService providerQueryService;
    private final ProviderCommandService providerCommandService;

    public ProviderController(ProviderQueryService providerQueryService, ProviderCommandService providerCommandService) {
        this.providerQueryService = providerQueryService;
        this.providerCommandService = providerCommandService;
    }

    @PostMapping
    public ResponseEntity<ProviderResource> createProvider(@RequestBody CreateProviderResource resource){
        var createProviderCommand = CreateProviderCommandFromResourceAssembler.toCommandFromResource(resource);
        var provider = providerCommandService.handle(createProviderCommand);
        if(provider.isEmpty()) return ResponseEntity.badRequest().build();
        var providerResource = ProviderResourceFromEntityAssembler.toResourceFromEntity(provider.get());
        return new ResponseEntity<>(providerResource, HttpStatus.CREATED);
    }

    @GetMapping("/{providerId}")
    public ResponseEntity<ProviderResource> getProvider(@PathVariable Long providerId){
        var getProviderByIdQuery = new GetProviderByIdQuery(providerId);
        var provider = providerQueryService.handle(getProviderByIdQuery);
        if(provider.isEmpty()) return ResponseEntity.badRequest().build();
        var providerResource = ProviderResourceFromEntityAssembler.toResourceFromEntity(provider.get());
        return new ResponseEntity<>(providerResource, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProviderResource>> getAllProviders(){
        var getAllProvidersQuery = new GetAllProvidersQuery();
        var providers = providerQueryService.handle(getAllProvidersQuery);
        var providerResources = providers.stream()
                .map(ProviderResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return new ResponseEntity<>(providerResources, HttpStatus.OK);
    }
}