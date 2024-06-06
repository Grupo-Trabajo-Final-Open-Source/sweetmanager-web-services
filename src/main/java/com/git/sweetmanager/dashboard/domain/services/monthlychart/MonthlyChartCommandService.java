package com.git.sweetmanager.dashboard.domain.services.monthlychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.MonthlyChart;
import com.git.sweetmanager.dashboard.domain.model.commands.monthlychart.CreateMonthlyChartCommand;

import java.util.Optional;

public interface MonthlyChartCommandService {
    Optional<MonthlyChart> handle(CreateMonthlyChartCommand command);
}