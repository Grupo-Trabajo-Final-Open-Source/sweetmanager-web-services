package com.git.sweetmanager.profile.application.internal.commandservices.customer;

import com.git.sweetmanager.profile.domain.model.aggregates.Customer;
import com.git.sweetmanager.profile.domain.model.commands.customer.CreateCustomerCommand;
import com.git.sweetmanager.profile.domain.model.commands.customer.DeleteCustomerCommand;
import com.git.sweetmanager.profile.domain.model.commands.customer.UpdateCustomerCommand;
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
        if(command.email() == null || command.email().isEmpty())
            throw new IllegalArgumentException("Email is required");
        if(command.phoneNumber() == null || command.phoneNumber().isEmpty())
            throw new IllegalArgumentException("Phone number is required");
        if(command.reservationDate() == null)
            throw new IllegalArgumentException("Reservation date is required");
        if(command.reservationTime() == null)
            throw new IllegalArgumentException("Reservation time is required");
        if(command.cost() <= 0)
            throw new IllegalArgumentException("Cost must be greater than 0");

        var customer = new Customer(command);

        customerRepository.save(customer);

        return Optional.of(customer);
    }

    @Override
    public Optional<Customer> handle(UpdateCustomerCommand command) {
        if(command.name() == null || command.name().isEmpty())
            throw new IllegalArgumentException("Name is required");
        if(command.email() == null || command.email().isEmpty())
            throw new IllegalArgumentException("Email is required");
        if(command.phoneNumber() == null || command.phoneNumber().isEmpty())
            throw new IllegalArgumentException("Phone number is required");
        if(command.reservationDate() == null)
            throw new IllegalArgumentException("Reservation date is required");
        if(command.reservationTime() == null)
            throw new IllegalArgumentException("Reservation time is required");
        if(command.cost() <= 0)
            throw new IllegalArgumentException("Cost must be greater than 0");

        var customer = new Customer(command);

        customerRepository.save(customer);

        return Optional.of(customer);
    }

    @Override
    public void handle(DeleteCustomerCommand command) {
        if(!customerRepository.existsById(command.id())){
            throw new IllegalArgumentException("Provider doesn't exist");
        }
        try{
            customerRepository.deleteById(command.id());
        } catch(Exception e){
            throw new IllegalArgumentException("Error occurred while deleting provider: " + e.getMessage());
        }
    }
}