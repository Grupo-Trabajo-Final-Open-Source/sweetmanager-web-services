package com.git.sweetmanager.dashboard.interfaces.rest.transform.provider;

import com.git.sweetmanager.dashboard.domain.model.commands.provider.UpdateProviderCommand;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.provider.UpdateProviderResource;

public class UpdateProviderCommandFromResourceAssembler {
    public static UpdateProviderCommand toCommandFromResource(UpdateProviderResource resource) {
        return new UpdateProviderCommand(resource.id(),resource.name(), resource.contact(), resource.address(), resource.product());
    }
}