package com.git.sweetmanager.dashboard.application.internal.commandservices.monthlychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.MonthlyChart;
import com.git.sweetmanager.dashboard.domain.model.commands.monthlychart.CreateMonthlyChartCommand;
import com.git.sweetmanager.dashboard.domain.services.monthlychart.MonthlyChartCommandService;
import com.git.sweetmanager.dashboard.infrastructure.persistence.mongo.repositories.monthlychart.MonthlyChartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonthlyChartCommandServiceImpl implements MonthlyChartCommandService {
    private final MonthlyChartRepository monthlyChartRepository;

    public MonthlyChartCommandServiceImpl(MonthlyChartRepository monthlyChartRepository) {
        this.monthlyChartRepository = monthlyChartRepository;
    }

    @Override
    public Optional<MonthlyChart> handle(CreateMonthlyChartCommand command) {
        if(command.month() == null || command.month().isEmpty())
            throw new IllegalArgumentException("Month is required");
        if(command.total() <= 0)
            throw new IllegalArgumentException("Total must be greater than zero");

        var monthlyChart = new MonthlyChart(command);

        monthlyChartRepository.save(monthlyChart);

        return Optional.empty();
    }
}