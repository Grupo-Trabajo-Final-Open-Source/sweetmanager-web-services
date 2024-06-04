package com.git.sweetmanager.rooms.interfaces.rest.transform;

import com.git.sweetmanager.rooms.domain.model.commands.CreateBookingCommand;
import com.git.sweetmanager.rooms.interfaces.rest.resources.CreateBookingResource;

public class CreateBookingCommandFromResourceAssembler {

    public static CreateBookingCommand toCommandFromResource(CreateBookingResource resource) {
        return new CreateBookingCommand(resource.clientId(), resource.bedroomId(),
                resource.startDate(), resource.finalDate(), resource.totalPrice(),
                resource.state());
    }
}