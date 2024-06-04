package com.git.sweetmanager.rooms.interfaces.rest.transform;

import com.git.sweetmanager.rooms.domain.model.commands.CreateBedroomCommand;

public class CreateBedroomCommandFromResourceAssembler {

    public static CreateBedroomCommand toCommandFromResource(CreateBedroomCommand resource) {

        return new CreateBedroomCommand(resource.typeBedroomId(), resource.workerId(),
                resource.totalBeds(), resource.totalBathroom(), resource.totalTelevision(), resource.state());
    }
}