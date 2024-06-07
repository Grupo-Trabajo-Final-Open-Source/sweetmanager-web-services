package com.git.sweetmanager.dashboard.interfaces.rest.transform.monthlychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.MonthlyChart;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.monthlychart.MonthlyChartResource;

public class MonthlyChartResourceFromEntityAssembler {
    public static MonthlyChartResource toResourceFromEntity(MonthlyChart entity) {
        return new MonthlyChartResource(entity.getId(), entity.getMonth(), entity.getTotal());
    }
}