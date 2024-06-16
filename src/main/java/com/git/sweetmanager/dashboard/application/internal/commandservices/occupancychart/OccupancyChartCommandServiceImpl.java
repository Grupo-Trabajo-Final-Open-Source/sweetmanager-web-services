package com.git.sweetmanager.dashboard.application.internal.commandservices.occupancychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.OccupancyChart;
import com.git.sweetmanager.dashboard.domain.model.commands.occupancychart.CreateOccupancyChartCommand;
import com.git.sweetmanager.dashboard.domain.services.occupancychart.OccupancyChartCommandService;
import com.git.sweetmanager.dashboard.infrastructure.persistence.mongo.repositories.occupancychart.OccupancyChartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OccupancyChartCommandServiceImpl implements OccupancyChartCommandService {
    private final OccupancyChartRepository occupancyChartRepository;

    public OccupancyChartCommandServiceImpl(OccupancyChartRepository occupancyChartRepository) {
        this.occupancyChartRepository = occupancyChartRepository;
    }

    @Override
    public Optional<OccupancyChart> handle(CreateOccupancyChartCommand command) {
        if(command.roomType() == null || command.roomType().isEmpty())
            throw new IllegalArgumentException("Room Type is required");
        if(command.total() <= 0)
            throw new IllegalArgumentException("Total must be greater than zero");

        var occupancyChart = new OccupancyChart(command);

        occupancyChartRepository.save(occupancyChart);

        return Optional.of(occupancyChart);
    }
}