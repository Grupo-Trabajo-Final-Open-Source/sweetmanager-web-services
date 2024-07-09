package com.git.sweetmanager.rooms.interfaces.rest.transform.bedroom;

import com.git.sweetmanager.rooms.domain.model.aggregates.Bedroom;
import com.git.sweetmanager.rooms.interfaces.rest.resources.bedroom.BedroomResource;

public class BedroomResourceFromEntityAssembler {

    public static BedroomResource toResourceFromEntity(Bedroom entity){
        return new BedroomResource(entity.getId(), entity.getClientName(), entity.getWorkerName(),
                entity.getTotalBeds(),entity.getTotalBathroom(), entity.getTotalTelevision(),
                entity.getState(), entity.getName(),entity.getDescription(), entity.getPrice());
    }
}
