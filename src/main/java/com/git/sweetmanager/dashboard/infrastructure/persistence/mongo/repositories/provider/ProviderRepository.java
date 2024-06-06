package com.git.sweetmanager.dashboard.infrastructure.persistence.mongo.repositories.provider;

import com.git.sweetmanager.dashboard.domain.model.aggregates.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProviderRepository extends MongoRepository<Provider, Long> {
    Optional<Provider> findById(Long id);
}