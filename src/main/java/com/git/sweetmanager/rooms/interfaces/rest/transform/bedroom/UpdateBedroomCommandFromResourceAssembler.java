package com.git.sweetmanager.rooms.interfaces.rest.transform.bedroom;

import com.git.sweetmanager.rooms.domain.model.commands.UpdateBedroomCommand;
import com.git.sweetmanager.rooms.interfaces.rest.resources.bedroom.UpdateBedroomResource;

public class UpdateBedroomCommandFromResourceAssembler {

    public static UpdateBedroomCommand toCommandFromResource(UpdateBedroomResource resource) {
        return new UpdateBedroomCommand(resource.id(), resource.workName(), resource.totalBeds(), resource.clientName(),
                resource.totalBathroom(), resource.totalTelevision(), resource.state(), resource.name(),
                resource.description(), resource.price());
    }
}
