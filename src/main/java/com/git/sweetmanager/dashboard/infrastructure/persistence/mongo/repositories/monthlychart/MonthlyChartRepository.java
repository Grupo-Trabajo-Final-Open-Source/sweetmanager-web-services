package com.git.sweetmanager.dashboard.infrastructure.persistence.mongo.repositories.monthlychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.MonthlyChart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MonthlyChartRepository extends MongoRepository<MonthlyChart, Long> {
    Optional<MonthlyChart> findById(Long id);
}