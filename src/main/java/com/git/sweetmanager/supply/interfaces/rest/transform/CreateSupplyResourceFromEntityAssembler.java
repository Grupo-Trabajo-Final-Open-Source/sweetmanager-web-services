package com.git.sweetmanager.supply.interfaces.rest.transform;

import com.git.sweetmanager.supply.domain.model.commands.CreateSupplyCommand;
import com.git.sweetmanager.supply.interfaces.rest.resources.CreateSupplyResource;

public class CreateSupplyResourceFromEntityAssembler {
    public static CreateSupplyCommand toCommandFromResource(CreateSupplyResource resource){
        return new CreateSupplyCommand(resource.product(), resource.quantity(), resource.address(), resource.expire());
    }
}
