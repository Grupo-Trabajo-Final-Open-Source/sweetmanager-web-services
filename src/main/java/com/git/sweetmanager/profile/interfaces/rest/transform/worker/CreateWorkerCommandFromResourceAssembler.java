package com.git.sweetmanager.profile.interfaces.rest.transform.worker;

import com.git.sweetmanager.profile.domain.model.commands.worker.CreateWorkerCommand;
import com.git.sweetmanager.profile.interfaces.rest.resources.worker.CreateWorkerResource;

public class CreateWorkerCommandFromResourceAssembler {
    public static CreateWorkerCommand toCommandFromResource(CreateWorkerResource resource) {
        return new CreateWorkerCommand(resource.name(), resource.email(), resource.company(), resource.role(), resource.password());
    }
}