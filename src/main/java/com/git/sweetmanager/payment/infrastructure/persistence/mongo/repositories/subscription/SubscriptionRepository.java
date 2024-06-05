package com.git.sweetmanager.payment.infrastructure.persistence.mongo.repositories.subscription;

import com.git.sweetmanager.payment.domain.model.aggregates.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubscriptionRepository extends MongoRepository<Subscription, Long> {

    Optional<Subscription> findById(Long id);

}
