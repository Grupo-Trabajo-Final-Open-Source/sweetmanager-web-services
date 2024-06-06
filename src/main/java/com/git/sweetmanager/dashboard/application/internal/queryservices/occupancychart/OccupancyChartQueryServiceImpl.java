package com.git.sweetmanager.dashboard.application.internal.queryservices.occupancychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.OccupancyChart;
import com.git.sweetmanager.dashboard.domain.model.queries.occupancychart.GetAllOccupancyChartsQuery;
import com.git.sweetmanager.dashboard.domain.model.queries.occupancychart.GetOccupancyChartByIdQuery;
import com.git.sweetmanager.dashboard.domain.services.occupancychart.OccupancyChartQueryService;
import com.git.sweetmanager.dashboard.infrastructure.persistence.mongo.repositories.occupancychart.OccupancyChartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccupancyChartQueryServiceImpl implements OccupancyChartQueryService {

    private final OccupancyChartRepository occupancyChartRepository;

    public OccupancyChartQueryServiceImpl(OccupancyChartRepository occupancyChartRepository) {
        this.occupancyChartRepository = occupancyChartRepository;
    }

    @Override
    public List<OccupancyChart> handle(GetAllOccupancyChartsQuery query) {
        return occupancyChartRepository.findAll();
    }

    @Override
    public Optional<OccupancyChart> handle(GetOccupancyChartByIdQuery query) {
        return occupancyChartRepository.findById(query.ocuppancyChartId());
    }
}