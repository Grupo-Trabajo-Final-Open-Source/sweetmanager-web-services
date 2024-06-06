package com.git.sweetmanager.dashboard.infrastructure.persistence.mongo.repositories.occupancychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.OccupancyChart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OccupancyChartRepository extends MongoRepository<OccupancyChart, Long> {
    Optional<OccupancyChart> findById(Long id);
}