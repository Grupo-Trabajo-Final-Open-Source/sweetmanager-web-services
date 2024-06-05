package com.git.sweetmanager.profile.application.internal.commandservices.customer;

import com.git.sweetmanager.profile.domain.model.aggregates.Customer;
import com.git.sweetmanager.profile.domain.model.commands.customer.CreateCustomerCommand;
import com.git.sweetmanager.profile.domain.services.customer.CustomerCommandService;
import com.git.sweetmanager.profile.infrastructure.persistence.mongo.repositories.customer.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerCommandServiceImpl implements CustomerCommandService {
    private final CustomerRepository customerRepository;

    public CustomerCommandServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> handle(CreateCustomerCommand command) {
        if(command.name() == null || command.name().isEmpty())
            throw new IllegalArgumentException("Name is required");
        if(command.dni() == null || command.dni().isEmpty())
            throw new IllegalArgumentException("DNI is required");
        if(command.age() <= 0)
            throw new IllegalArgumentException("Age must be greater than 0");
        if(command.email() == null || command.email().isEmpty())
            throw new IllegalArgumentException("Email is required");

        var customer = new Customer(command);

        customerRepository.save(customer);

        return Optional.empty();
    }
}