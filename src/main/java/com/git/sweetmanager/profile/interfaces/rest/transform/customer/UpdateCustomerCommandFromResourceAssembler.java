package com.git.sweetmanager.profile.interfaces.rest.transform.customer;

import com.git.sweetmanager.profile.domain.model.commands.customer.UpdateCustomerCommand;
import com.git.sweetmanager.profile.interfaces.rest.resources.customer.UpdateCustomerResource;

public class UpdateCustomerCommandFromResourceAssembler {
    public static UpdateCustomerCommand toCommandFromResource(UpdateCustomerResource resource) {
        return new UpdateCustomerCommand(
                resource.id(),
                resource.name(),
                resource.email(),
                resource.phoneNumber(),
                resource.reservationDate(),
                resource.reservationTime(),
                resource.cost()
        );
    }
}