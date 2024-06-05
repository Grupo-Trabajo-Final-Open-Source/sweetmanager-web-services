package com.git.sweetmanager.profile.interfaces.rest.transform.customer;

import com.git.sweetmanager.profile.domain.model.commands.customer.CreateCustomerCommand;
import com.git.sweetmanager.profile.interfaces.rest.resources.customer.CreateCustomerResource;

public class CreateCustomerCommandFromResourceAssembler {
    public static CreateCustomerCommand toCommandFromResource(CreateCustomerResource resource) {
        return new CreateCustomerCommand(resource.name(), resource.DNI(), resource.age(), resource.email());
    }
}