package com.git.sweetmanager.supply.infrastructure.persistence.mongo.repositories;

import com.git.sweetmanager.supply.domain.model.aggregates.Supplie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SupplyRepository extends MongoRepository<Supplie, Long> {
    Optional<Supplie> findById(Long id);
}
