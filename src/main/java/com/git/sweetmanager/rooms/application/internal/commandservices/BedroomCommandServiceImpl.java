package com.git.sweetmanager.rooms.application.internal.commandservices;

import com.git.sweetmanager.rooms.domain.model.aggregates.Bedroom;
import com.git.sweetmanager.rooms.domain.model.commands.CreateBedroomCommand;
import com.git.sweetmanager.rooms.domain.model.commands.UpdateBedroomCommand;
import com.git.sweetmanager.rooms.domain.services.BedroomCommandService;
import com.git.sweetmanager.rooms.infraestructure.persistence.mongo.repositories.BedroomRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BedroomCommandServiceImpl implements BedroomCommandService {

    private final BedroomRepository repository;

    public BedroomCommandServiceImpl(BedroomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Bedroom> handle(CreateBedroomCommand command) {
        return Optional.empty();
    }

    @Override
    public Optional<Bedroom> handle(UpdateBedroomCommand command) {
        return Optional.empty();
    }
}
