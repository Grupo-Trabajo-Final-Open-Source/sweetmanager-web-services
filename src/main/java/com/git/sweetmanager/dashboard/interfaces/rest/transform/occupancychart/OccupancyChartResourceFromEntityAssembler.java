package com.git.sweetmanager.dashboard.interfaces.rest.transform.occupancychart;

import com.git.sweetmanager.dashboard.domain.model.aggregates.OccupancyChart;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.occupancychart.OccupancyChartResource;

public class OccupancyChartResourceFromEntityAssembler {
    public static OccupancyChartResource toResourceFromEntity(OccupancyChart entity) {
        return new OccupancyChartResource(entity.getId(), entity.getRoomType(), entity.getTotal());
    }
}