package com.git.sweetmanager.rooms.infraestructure.persistence.mongo.repositories;

import com.git.sweetmanager.rooms.domain.model.aggregates.Bedroom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedroomRepository extends MongoRepository<Bedroom, Long> {
}
