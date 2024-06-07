package com.git.sweetmanager.profile.domain.services.customer;

import com.git.sweetmanager.profile.domain.model.aggregates.Customer;
import com.git.sweetmanager.profile.domain.model.commands.customer.CreateCustomerCommand;

import java.util.Optional;

public interface CustomerCommandService {
    Optional<Customer> handle(CreateCustomerCommand command);
}
