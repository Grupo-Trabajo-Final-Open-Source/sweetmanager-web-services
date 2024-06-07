package com.git.sweetmanager.profile.infrastructure.persistence.mongo.repositories.customer;

import com.git.sweetmanager.profile.domain.model.aggregates.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
    Optional<Customer> findById(int id);
}
