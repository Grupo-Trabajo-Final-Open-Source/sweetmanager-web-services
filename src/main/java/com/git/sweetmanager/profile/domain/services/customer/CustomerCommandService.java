package com.git.sweetmanager.profile.domain.services.customer;

import com.git.sweetmanager.dashboard.domain.model.commands.provider.DeleteProviderCommand;
import com.git.sweetmanager.profile.domain.model.aggregates.Customer;
import com.git.sweetmanager.profile.domain.model.commands.customer.CreateCustomerCommand;
import com.git.sweetmanager.profile.domain.model.commands.customer.DeleteCustomerCommand;
import com.git.sweetmanager.profile.domain.model.commands.customer.UpdateCustomerCommand;

import java.util.Optional;

public interface CustomerCommandService {
    Optional<Customer> handle(CreateCustomerCommand command);
    void handle(DeleteCustomerCommand command);
    Optional<Customer> handle(UpdateCustomerCommand command);
}
