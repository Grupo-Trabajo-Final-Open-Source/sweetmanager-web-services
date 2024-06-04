package com.git.sweetmanager.rooms.application.internal.commandservices;

import com.git.sweetmanager.rooms.domain.model.aggregates.Bedroom;
import com.git.sweetmanager.rooms.domain.model.commands.CreateBedroomCommand;
import com.git.sweetmanager.rooms.domain.model.commands.UpdateBedroomCommand;
import com.git.sweetmanager.rooms.domain.services.BedroomCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BedroomCommandServiceImpl implements BedroomCommandService {
    @Override
    public Optional<Bedroom> handle(CreateBedroomCommand command) {
        return Optional.empty();
    }

    @Override
    public Optional<Bedroom> handle(UpdateBedroomCommand command) {
        return Optional.empty();
    }
}
