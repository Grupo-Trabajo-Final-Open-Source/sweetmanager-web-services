package com.git.sweetmanager.rooms.infraestructure.persistence.mongo.repositories;

import com.git.sweetmanager.rooms.domain.model.aggregates.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<Booking, Long> {
}