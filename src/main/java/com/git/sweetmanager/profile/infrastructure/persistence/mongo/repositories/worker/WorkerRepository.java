package com.git.sweetmanager.profile.infrastructure.persistence.mongo.repositories.worker;

import com.git.sweetmanager.profile.domain.model.aggregates.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WorkerRepository extends MongoRepository<Worker, Long> {
    Optional<Worker> findById(int id);
}
