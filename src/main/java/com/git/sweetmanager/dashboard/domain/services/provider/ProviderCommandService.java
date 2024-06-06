package com.git.sweetmanager.dashboard.domain.services.provider;

import com.git.sweetmanager.dashboard.domain.model.aggregates.Provider;
import com.git.sweetmanager.dashboard.domain.model.commands.provider.CreateProviderCommand;

import java.util.Optional;

public interface ProviderCommandService {
    Optional<Provider> handle(CreateProviderCommand command);
}