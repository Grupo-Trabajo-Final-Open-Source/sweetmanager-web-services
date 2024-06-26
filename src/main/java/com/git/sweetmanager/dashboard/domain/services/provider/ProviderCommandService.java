package com.git.sweetmanager.dashboard.domain.services.provider;

import com.git.sweetmanager.dashboard.domain.model.aggregates.Provider;
import com.git.sweetmanager.dashboard.domain.model.commands.provider.CreateProviderCommand;
import com.git.sweetmanager.dashboard.domain.model.commands.provider.DeleteProviderCommand;
import com.git.sweetmanager.dashboard.domain.model.commands.provider.UpdateProviderCommand;

import java.util.Optional;

public interface ProviderCommandService {
    Optional<Provider> handle(CreateProviderCommand command);
    void handle(DeleteProviderCommand command);
    Optional<Provider> handle(UpdateProviderCommand command);
}