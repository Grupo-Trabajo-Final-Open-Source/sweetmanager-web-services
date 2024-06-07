package com.git.sweetmanager.dashboard.domain.services.monthlychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.MonthlyChart;
import com.git.sweetmanager.dashboard.domain.model.queries.monthlychart.GetAllMonthlyChartsQuery;
import com.git.sweetmanager.dashboard.domain.model.queries.monthlychart.GetMonthlyChartByIdQuery;

import java.util.List;
import java.util.Optional;

public interface MonthlyChartQueryService {
    List<MonthlyChart> handle(GetAllMonthlyChartsQuery query);

    Optional<MonthlyChart> handle(GetMonthlyChartByIdQuery query);
}