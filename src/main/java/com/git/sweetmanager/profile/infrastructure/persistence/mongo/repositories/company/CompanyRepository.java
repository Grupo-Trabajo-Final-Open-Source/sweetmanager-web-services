package com.git.sweetmanager.profile.infrastructure.persistence.mongo.repositories.company;

import com.git.sweetmanager.profile.domain.model.aggregates.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CompanyRepository extends MongoRepository<Company, Long> {
    Optional<Company> findById(int id);
}
