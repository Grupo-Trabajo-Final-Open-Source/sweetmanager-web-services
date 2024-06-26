package com.git.sweetmanager.rooms.interfaces.rest.transform;

import com.git.sweetmanager.rooms.domain.model.commands.UpdateBedroomCommand;
import com.git.sweetmanager.rooms.interfaces.rest.resources.UpdateBedroomResource;

public class UpdateBedroomCommandFromResourceAssembler {

    public static UpdateBedroomCommand toCommandFromResource(UpdateBedroomResource resource) {
        return new UpdateBedroomCommand(resource.id(), resource.typeBedroomId(), resource.workerId(),
                resource.workerId(), resource.totalBathroom(), resource.totalTelevision(),
                resource.state());
    }
}
