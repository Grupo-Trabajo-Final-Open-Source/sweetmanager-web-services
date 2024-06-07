package com.git.sweetmanager.rooms.domain.services;

import com.git.sweetmanager.rooms.domain.model.aggregates.Bedroom;
import com.git.sweetmanager.rooms.domain.model.commands.CreateBedroomCommand;
import com.git.sweetmanager.rooms.domain.model.commands.UpdateBedroomCommand;

import java.util.Optional;

public interface BedroomCommandService {

    Optional<Bedroom> handle(CreateBedroomCommand command);
    Optional<Bedroom> handle(UpdateBedroomCommand command);
}