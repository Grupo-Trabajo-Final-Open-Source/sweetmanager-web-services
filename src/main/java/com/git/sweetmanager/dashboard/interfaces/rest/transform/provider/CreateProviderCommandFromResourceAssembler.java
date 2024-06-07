package com.git.sweetmanager.dashboard.interfaces.rest.transform.provider;

import com.git.sweetmanager.dashboard.domain.model.commands.provider.CreateProviderCommand;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.provider.CreateProviderResource;

public class CreateProviderCommandFromResourceAssembler {
    public static CreateProviderCommand toCommandFromResource(CreateProviderResource resource) {
        return new CreateProviderCommand(resource.name(), resource.contact(), resource.address(), resource.product());
    }
}