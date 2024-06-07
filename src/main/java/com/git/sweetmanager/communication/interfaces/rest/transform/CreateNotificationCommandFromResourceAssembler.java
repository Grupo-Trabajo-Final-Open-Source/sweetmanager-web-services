package com.git.sweetmanager.communication.interfaces.rest.transform;

import com.git.sweetmanager.communication.domain.model.commands.CreateNotificationCommand;
import com.git.sweetmanager.communication.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource) {
        return new CreateNotificationCommand(resource.title(), resource.message(), resource.date());
    }
}
