package com.git.sweetmanager.rooms.infraestructure.persistence.mongo.repositories;

import com.git.sweetmanager.rooms.domain.model.aggregates.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, Long> {
}