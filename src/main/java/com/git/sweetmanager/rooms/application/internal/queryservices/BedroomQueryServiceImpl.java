package com.git.sweetmanager.rooms.application.internal.queryservices;

import com.git.sweetmanager.rooms.domain.model.aggregates.Bedroom;
import com.git.sweetmanager.rooms.domain.model.queries.GetAllBedroomsQuery;
import com.git.sweetmanager.rooms.domain.model.queries.GetBedroomByIdQuery;
import com.git.sweetmanager.rooms.domain.services.BedroomQueryService;
import com.git.sweetmanager.rooms.infraestructure.persistence.mongo.repositories.BedroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BedroomQueryServiceImpl implements BedroomQueryService {

    private final BedroomRepository bedroomRepository;

    public BedroomQueryServiceImpl(BedroomRepository bedroomRepository) {
        this.bedroomRepository = bedroomRepository;
    }

    @Override
    public List<Bedroom> handle(GetAllBedroomsQuery query) {

        return bedroomRepository.findAll();
    }

    @Override
    public Optional<Bedroom> handle(GetBedroomByIdQuery query) {

        return null;
    }
}
