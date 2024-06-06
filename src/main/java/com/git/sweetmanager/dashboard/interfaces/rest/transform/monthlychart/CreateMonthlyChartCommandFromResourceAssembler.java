package com.git.sweetmanager.dashboard.interfaces.rest.transform.monthlychart;

import com.git.sweetmanager.dashboard.domain.model.commands.monthlychart.CreateMonthlyChartCommand;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.monthlychart.CreateMonthlyChartResource;

public class CreateMonthlyChartCommandFromResourceAssembler {
    public static CreateMonthlyChartCommand toCommandFromResource(CreateMonthlyChartResource resource) {
        return new CreateMonthlyChartCommand(resource.month(), resource.total());
    }
}