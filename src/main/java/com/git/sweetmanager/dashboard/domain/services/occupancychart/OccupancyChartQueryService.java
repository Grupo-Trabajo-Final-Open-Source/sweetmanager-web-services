package com.git.sweetmanager.dashboard.domain.services.occupancychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.OccupancyChart;
import com.git.sweetmanager.dashboard.domain.model.queries.occupancychart.GetAllOccupancyChartsQuery;
import com.git.sweetmanager.dashboard.domain.model.queries.occupancychart.GetOccupancyChartByIdQuery;

import java.util.List;
import java.util.Optional;

public interface OccupancyChartQueryService {
    List<OccupancyChart> handle(GetAllOccupancyChartsQuery query);

    Optional<OccupancyChart> handle(GetOccupancyChartByIdQuery query);
}