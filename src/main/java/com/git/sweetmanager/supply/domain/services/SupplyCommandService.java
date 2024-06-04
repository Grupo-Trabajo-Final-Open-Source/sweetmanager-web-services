package com.git.sweetmanager.supply.domain.services;

import com.git.sweetmanager.supply.domain.model.aggregates.Supply;
import com.git.sweetmanager.supply.domain.model.commands.CreateSupplyCommand;

import java.util.Optional;

public interface SupplyCommandService {
    Optional<Supply> handle(CreateSupplyCommand command);
}
