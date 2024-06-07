package com.git.sweetmanager.rooms.interfaces.rest.transform;

import com.git.sweetmanager.rooms.domain.model.aggregates.Bedroom;
import com.git.sweetmanager.rooms.interfaces.rest.resources.BedroomResource;

public class BedroomResourceFromEntityAssembler {

    public static BedroomResource toResourceFromEntity(Bedroom entity){
        return new BedroomResource(entity.GetTypeBedroomId(),
                entity.GetWorkerId(), entity.GetTotalBeds(),
                entity.GetTotalBathroom(), entity.GetTotalTelevision(),
                entity.GetState());
    }
}
