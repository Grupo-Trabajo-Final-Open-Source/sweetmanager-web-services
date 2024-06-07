package com.git.sweetmanager.supply.infrastructure.persistence.mongo.repositories;

import com.git.sweetmanager.supply.domain.model.aggregates.Supply;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SupplyRepository extends MongoRepository<Supply, Long> {
    Optional<Supply> findById(Long id);
}
