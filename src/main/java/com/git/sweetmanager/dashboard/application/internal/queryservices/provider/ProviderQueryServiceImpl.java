package com.git.sweetmanager.dashboard.application.internal.queryservices.provider;

import com.git.sweetmanager.dashboard.domain.model.aggregates.Provider;
import com.git.sweetmanager.dashboard.domain.model.queries.provider.GetAllProvidersQuery;
import com.git.sweetmanager.dashboard.domain.model.queries.provider.GetProviderByIdQuery;
import com.git.sweetmanager.dashboard.domain.services.provider.ProviderQueryService;
import com.git.sweetmanager.dashboard.infrastructure.persistence.mongo.repositories.provider.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderQueryServiceImpl implements ProviderQueryService {

    private final ProviderRepository providerRepository;

    public ProviderQueryServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public List<Provider> handle(GetAllProvidersQuery query) {
        return providerRepository.findAll();
    }

    @Override
    public Optional<Provider> handle(GetProviderByIdQuery query) {
        return providerRepository.findById(query.providerId());
    }
}