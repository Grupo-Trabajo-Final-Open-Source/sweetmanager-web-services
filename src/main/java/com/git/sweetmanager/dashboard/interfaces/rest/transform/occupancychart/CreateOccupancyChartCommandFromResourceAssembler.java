package com.git.sweetmanager.dashboard.interfaces.rest.transform.occupancychart;

import com.git.sweetmanager.dashboard.domain.model.commands.occupancychart.CreateOccupancyChartCommand;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.occupancychart.CreateOccupancyChartResource;

public class CreateOccupancyChartCommandFromResourceAssembler {
    public static CreateOccupancyChartCommand toCommandFromResource(CreateOccupancyChartResource resource) {
        return new CreateOccupancyChartCommand(resource.roomType(), resource.total());
    }
}
