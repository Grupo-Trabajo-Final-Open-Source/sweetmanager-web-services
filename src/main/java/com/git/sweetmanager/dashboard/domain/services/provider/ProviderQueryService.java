package com.git.sweetmanager.dashboard.domain.services.provider;

import com.git.sweetmanager.dashboard.domain.model.aggregates.Provider;
import com.git.sweetmanager.dashboard.domain.model.queries.provider.GetAllProvidersQuery;
import com.git.sweetmanager.dashboard.domain.model.queries.provider.GetProviderByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProviderQueryService {
    List<Provider> handle(GetAllProvidersQuery query);

    Optional<Provider> handle(GetProviderByIdQuery query);
}