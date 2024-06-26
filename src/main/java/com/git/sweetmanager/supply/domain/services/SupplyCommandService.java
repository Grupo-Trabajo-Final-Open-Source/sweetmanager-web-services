package com.git.sweetmanager.supply.domain.services;

import com.git.sweetmanager.supply.domain.model.aggregates.Supplie;
import com.git.sweetmanager.supply.domain.model.commands.CreateSupplyCommand;
import com.git.sweetmanager.supply.domain.model.commands.DeleteSupplyCommand;
import com.git.sweetmanager.supply.domain.model.commands.UpdateSupplyCommand;

import java.util.Optional;

public interface SupplyCommandService {
    Optional<Supplie> handle(CreateSupplyCommand command);
    Optional<Supplie> handle(UpdateSupplyCommand command);
    void handle(DeleteSupplyCommand command);
}
