package com.git.sweetmanager.rooms.interfaces.rest.transform.booking;

import com.git.sweetmanager.rooms.domain.model.commands.UpdateBookingCommand;
import com.git.sweetmanager.rooms.interfaces.rest.resources.booking.UpdateBookingResource;

public class UpdateBookingCommandFromResourceAssembler {

    public static UpdateBookingCommand toCommandFromResource(UpdateBookingResource resource) {
        return new UpdateBookingCommand(resource.clientId());
    }
}
