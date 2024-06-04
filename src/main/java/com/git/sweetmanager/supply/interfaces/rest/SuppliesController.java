package com.git.sweetmanager.supply.interfaces.rest;

import com.git.sweetmanager.supply.domain.model.queries.GetAllSuppliesQuery;
import com.git.sweetmanager.supply.domain.model.queries.GetSupplyByIdQuery;
import com.git.sweetmanager.supply.domain.services.SupplyCommandService;
import com.git.sweetmanager.supply.domain.services.SupplyQueryService;
import com.git.sweetmanager.supply.interfaces.rest.resources.CreateSupplyResource;
import com.git.sweetmanager.supply.interfaces.rest.resources.SupplyResource;
import com.git.sweetmanager.supply.interfaces.rest.transform.CreateSupplyResourceFromEntityAssembler;
import com.git.sweetmanager.supply.interfaces.rest.transform.SupplyResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/supplies", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Supplies", description = "Supplies Management Endpoints")
public class SuppliesController {
    private final SupplyQueryService supplyQueryService;
    private final SupplyCommandService supplyCommandService;

    public SuppliesController(SupplyQueryService supplyQueryService, SupplyCommandService supplyCommandService) {
        this.supplyQueryService = supplyQueryService;
        this.supplyCommandService = supplyCommandService;
    }

    @PostMapping
    public ResponseEntity<SupplyResource> createSupply(@RequestBody CreateSupplyResource resource){
        var createSupplyCommand = CreateSupplyResourceFromEntityAssembler.toCommandFromResource(resource);
        var supply = supplyCommandService.handle(createSupplyCommand);
        if (supply.isEmpty()) return ResponseEntity.badRequest().build();
        var supplyResource = SupplyResourceFromEntityAssembler.toResourceFromEntity(supply.get());

        return new ResponseEntity<>(supplyResource, HttpStatus.CREATED);
    }

    @GetMapping("/{supplyId}")
    public ResponseEntity<SupplyResource> getSupplyById(@PathVariable Long supplyId){
        var getSupplyByIdQuery = new GetSupplyByIdQuery(supplyId);
        var supply = supplyQueryService.handle(getSupplyByIdQuery);
        if (supply.isEmpty()) return ResponseEntity.notFound().build();
        var supplyResource = SupplyResourceFromEntityAssembler.toResourceFromEntity(supply.get());

        return ResponseEntity.ok(supplyResource);
    }

    @GetMapping
    public ResponseEntity<List<SupplyResource>> getAllSupplies(){
        var getAllSuppliesQuery = new GetAllSuppliesQuery();
        var supplies = supplyQueryService.handle(getAllSuppliesQuery);
        var suppliesResources = supplies.stream()
                .map(SupplyResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(suppliesResources);
    }
}
