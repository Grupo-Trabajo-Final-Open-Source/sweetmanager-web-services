package com.git.sweetmanager.supply.interfaces.rest.transform;

import com.git.sweetmanager.supply.domain.model.aggregates.Supply;
import com.git.sweetmanager.supply.interfaces.rest.resources.SupplyResource;

public class SupplyResourceFromEntityAssembler {
    public static SupplyResource toResourceFromEntity(Supply entity){
        return new SupplyResource(entity.getId(), entity.getProduct(), entity.getQuantity(), entity.getAddress(), entity.getExpire());
    }
}
