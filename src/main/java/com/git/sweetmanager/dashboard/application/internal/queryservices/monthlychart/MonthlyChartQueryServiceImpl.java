package com.git.sweetmanager.dashboard.application.internal.queryservices.monthlychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.MonthlyChart;
import com.git.sweetmanager.dashboard.domain.model.queries.monthlychart.GetAllMonthlyChartsQuery;
import com.git.sweetmanager.dashboard.domain.model.queries.monthlychart.GetMonthlyChartByIdQuery;
import com.git.sweetmanager.dashboard.domain.services.monthlychart.MonthlyChartQueryService;
import com.git.sweetmanager.dashboard.infrastructure.persistence.mongo.repositories.monthlychart.MonthlyChartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonthlyChartQueryServiceImpl implements MonthlyChartQueryService {

    private final MonthlyChartRepository monthlyChartRepository;

    public MonthlyChartQueryServiceImpl(MonthlyChartRepository monthlyChartRepository) {
        this.monthlyChartRepository = monthlyChartRepository;
    }

    @Override
    public List<MonthlyChart> handle(GetAllMonthlyChartsQuery query) {
        return monthlyChartRepository.findAll();
    }

    @Override
    public Optional<MonthlyChart> handle(GetMonthlyChartByIdQuery query) {
        return monthlyChartRepository.findById(query.monthlyChartId());
    }
}