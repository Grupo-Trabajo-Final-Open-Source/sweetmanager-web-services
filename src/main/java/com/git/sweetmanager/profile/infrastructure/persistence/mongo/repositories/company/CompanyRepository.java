package com.git.sweetmanager.profile.infrastructure.persistence.mongo.repositories.company;

import com.git.sweetmanager.profile.domain.model.aggregates.Companie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CompanyRepository extends MongoRepository<Companie, Long> {
    Optional<Companie> findById(int id);
}
