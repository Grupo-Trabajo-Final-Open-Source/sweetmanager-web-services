package com.git.sweetmanager.dashboard.domain.services.occupancychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.OccupancyChart;
import com.git.sweetmanager.dashboard.domain.model.commands.occupancychart.CreateOccupancyChartCommand;

import java.util.Optional;

public interface OccupancyChartCommandService {
    Optional<OccupancyChart> handle(CreateOccupancyChartCommand command);
}