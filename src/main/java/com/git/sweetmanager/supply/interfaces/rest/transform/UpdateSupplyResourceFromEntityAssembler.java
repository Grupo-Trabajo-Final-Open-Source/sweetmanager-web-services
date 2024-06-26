package com.git.sweetmanager.supply.interfaces.rest.transform;

import com.git.sweetmanager.supply.domain.model.commands.UpdateSupplyCommand;
import com.git.sweetmanager.supply.interfaces.rest.resources.UpdateSupplyResource;

public class UpdateSupplyResourceFromEntityAssembler {
    public static UpdateSupplyCommand toCommandFromResource(UpdateSupplyResource resource) {
        return new UpdateSupplyCommand(resource.id(), resource.product(), resource.quantity(), resource.address(), resource.expire());
    }
}