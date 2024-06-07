package com.git.sweetmanager.communication.infrastructure.persistence.mongo.repositories;


import com.git.sweetmanager.communication.domain.model.aggregates.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface NotificationRepository extends MongoRepository<Notification, Long> {
    Optional<Notification> findById(int id);

}
