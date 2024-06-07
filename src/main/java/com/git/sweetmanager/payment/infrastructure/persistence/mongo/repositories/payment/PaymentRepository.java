package com.git.sweetmanager.payment.infrastructure.persistence.mongo.repositories.payment;

import com.git.sweetmanager.payment.domain.model.aggregates.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PaymentRepository extends MongoRepository<Payment, Long> {
    Optional<Payment> findById(Long id);

}
