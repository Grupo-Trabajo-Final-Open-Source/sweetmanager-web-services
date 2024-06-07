package com.git.sweetmanager.rooms.domain.services;

import com.git.sweetmanager.rooms.domain.model.aggregates.Bedroom;
import com.git.sweetmanager.rooms.domain.model.queries.GetAllBedroomsQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetBedroomByIdQuery;

import java.util.List;
import java.util.Optional;

public interface BedroomQueryService {

    List<Bedroom> handle(GetAllBedroomsQuery query);
    Optional<Bedroom> handle(GetBedroomByIdQuery query);
}
