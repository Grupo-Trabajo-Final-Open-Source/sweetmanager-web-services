package com.git.sweetmanager.dashboard.interfaces.rest;

import com.git.sweetmanager.dashboard.domain.model.queries.occupancychart.GetAllOccupancyChartsQuery;
import com.git.sweetmanager.dashboard.domain.model.queries.occupancychart.GetOccupancyChartByIdQuery;
import com.git.sweetmanager.dashboard.domain.services.occupancychart.OccupancyChartCommandService;
import com.git.sweetmanager.dashboard.domain.services.occupancychart.OccupancyChartQueryService;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.occupancychart.CreateOccupancyChartResource;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.occupancychart.OccupancyChartResource;
import com.git.sweetmanager.dashboard.interfaces.rest.transform.occupancychart.CreateOccupancyChartCommandFromResourceAssembler;
import com.git.sweetmanager.dashboard.interfaces.rest.transform.occupancychart.OccupancyChartResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/occupancycharts", produces = MediaType.APPLICATION_JSON_VALUE)
public class OccupancyChartController {
    private final OccupancyChartQueryService occupancyChartQueryService;
    private final OccupancyChartCommandService occupancyChartCommandService;

    public OccupancyChartController(OccupancyChartQueryService occupancyChartQueryService, OccupancyChartCommandService occupancyChartCommandService) {
        this.occupancyChartQueryService = occupancyChartQueryService;
        this.occupancyChartCommandService = occupancyChartCommandService;
    }

    @PostMapping
    public ResponseEntity<OccupancyChartResource> createOccupancyChart(@RequestBody CreateOccupancyChartResource resource){
        var createOccupancyChartCommand = CreateOccupancyChartCommandFromResourceAssembler.toCommandFromResource(resource);
        var occupancyChart = occupancyChartCommandService.handle(createOccupancyChartCommand);
        if(occupancyChart.isEmpty()) return ResponseEntity.badRequest().build();
        var occupancyChartResource = OccupancyChartResourceFromEntityAssembler.toResourceFromEntity(occupancyChart.get());
        return new ResponseEntity<>(occupancyChartResource, HttpStatus.CREATED);
    }

    @GetMapping("/{occupancyChartId}")
    public ResponseEntity<OccupancyChartResource> getOccupancyChart(@PathVariable Long occupancyChartId){
        var getOccupancyChartByIdQuery = new GetOccupancyChartByIdQuery(occupancyChartId);
        var occupancyChart = occupancyChartQueryService.handle(getOccupancyChartByIdQuery);
        if(occupancyChart.isEmpty()) return ResponseEntity.badRequest().build();
        var occupancyChartResource = OccupancyChartResourceFromEntityAssembler.toResourceFromEntity(occupancyChart.get());
        return new ResponseEntity<>(occupancyChartResource, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OccupancyChartResource>> getAllOccupancyCharts(){
        var getAllOccupancyChartsQuery = new GetAllOccupancyChartsQuery();
        var occupancyCharts = occupancyChartQueryService.handle(getAllOccupancyChartsQuery);
        var occupancyChartResources = occupancyCharts.stream()
                .map(OccupancyChartResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return new ResponseEntity<>(occupancyChartResources, HttpStatus.OK);
    }
}