package com.git.sweetmanager.profile.interfaces;

import com.git.sweetmanager.profile.domain.model.commands.customer.DeleteCustomerCommand;
import com.git.sweetmanager.profile.domain.model.queries.customer.GetAllCustomersQuery;
import com.git.sweetmanager.profile.domain.model.queries.customer.GetCustomerByIdQuery;
import com.git.sweetmanager.profile.domain.services.customer.CustomerCommandService;
import com.git.sweetmanager.profile.domain.services.customer.CustomerQueryService;
import com.git.sweetmanager.profile.interfaces.rest.resources.customer.CreateCustomerResource;
import com.git.sweetmanager.profile.interfaces.rest.resources.customer.CustomerResource;
import com.git.sweetmanager.profile.interfaces.rest.resources.customer.UpdateCustomerResource;
import com.git.sweetmanager.profile.interfaces.rest.transform.customer.CreateCustomerCommandFromResourceAssembler;
import com.git.sweetmanager.profile.interfaces.rest.transform.customer.CustomerResourceFromEntityAssembler;
import com.git.sweetmanager.profile.interfaces.rest.transform.customer.UpdateCustomerCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value= "/api/v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Customers", description = "Customer Management Endpoints")
public class CustomerController {
    private final CustomerQueryService customerQueryService;
    private final CustomerCommandService customerCommandService;

    public CustomerController(CustomerQueryService customerQueryService, CustomerCommandService customerCommandService) {
        this.customerQueryService = customerQueryService;
        this.customerCommandService = customerCommandService;
    }

    @PostMapping
    public ResponseEntity<CustomerResource> createCustomer(@RequestBody CreateCustomerResource resource) {
        var createCustomerCommand = CreateCustomerCommandFromResourceAssembler.toCommandFromResource(resource);
        var customer = customerCommandService.handle(createCustomerCommand);
        if (customer.isEmpty()) return ResponseEntity.badRequest().build();
        var customerResource = CustomerResourceFromEntityAssembler.toResourceFromEntity(customer.get());
        return new ResponseEntity<>(customerResource, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerResource> updateCustomer(@RequestBody UpdateCustomerResource resource) {
        var updateCustomerCommand = UpdateCustomerCommandFromResourceAssembler.toCommandFromResource(resource);
        var customer = customerCommandService.handle(updateCustomerCommand);
        if (customer.isEmpty()) return ResponseEntity.badRequest().build();
        var customerResource = CustomerResourceFromEntityAssembler.toResourceFromEntity(customer.get());
        return new ResponseEntity<>(customerResource, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        var deleteCustomerCommand = new DeleteCustomerCommand(customerId);
        customerCommandService.handle(deleteCustomerCommand);
        return ResponseEntity.ok("Customer with given id successfully deleted");
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResource> getCustomerById(@PathVariable Long customerId) {
        var getCustomerByIdQuery = new GetCustomerByIdQuery(customerId);
        var customer = customerQueryService.handle(getCustomerByIdQuery);
        if (customer.isEmpty()) return ResponseEntity.badRequest().build();
        var customerResource = CustomerResourceFromEntityAssembler.toResourceFromEntity(customer.get());
        return ResponseEntity.ok(customerResource);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResource>> getAllCustomers() {
        var getAllCustomersQuery = new GetAllCustomersQuery();
        var customers = customerQueryService.handle(getAllCustomersQuery);
        var customerResources = customers.stream()
                .map(CustomerResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerResources);
    }
}