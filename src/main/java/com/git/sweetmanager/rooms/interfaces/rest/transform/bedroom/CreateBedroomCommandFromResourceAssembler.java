package com.git.sweetmanager.rooms.interfaces.rest.transform.bedroom;

import com.git.sweetmanager.rooms.domain.model.commands.CreateBedroomCommand;
import com.git.sweetmanager.rooms.interfaces.rest.resources.bedroom.CreateBedroomResource;

public class CreateBedroomCommandFromResourceAssembler {

    public static CreateBedroomCommand toCommandFromResource(CreateBedroomResource resource) {

        return new CreateBedroomCommand(resource.worker(), resource.totalBeds(),resource.clientName(), resource.totalBathroom(),
                resource.totalTelevision(), resource.state(), resource.name(), resource.description(), resource.price()
        );
    }
}