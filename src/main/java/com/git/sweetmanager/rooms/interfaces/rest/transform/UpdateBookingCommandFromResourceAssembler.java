package com.git.sweetmanager.rooms.interfaces.rest.transform;

import com.git.sweetmanager.rooms.domain.model.commands.UpdateBookingCommand;
import com.git.sweetmanager.rooms.interfaces.rest.resources.UpdateBookingResource;

public class UpdateBookingCommandFromResourceAssembler {

    public static UpdateBookingCommand updateBookingCommandFromResource(UpdateBookingResource resource) {
        return new UpdateBookingCommand(resource.clientId());
    }
}
