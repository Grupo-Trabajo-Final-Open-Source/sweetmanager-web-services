package com.git.sweetmanager.communication.infrastructure.persistence.mongo.repositories;


import com.git.sweetmanager.communication.domain.model.aggregates.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface NotificationRepository extends MongoRepository<Notification, Long> {
    Optional<Notification> findById(int id);

}
