package com.git.sweetmanager.dashboard.interfaces.rest;

import com.git.sweetmanager.dashboard.domain.model.queries.monthlychart.GetAllMonthlyChartsQuery;
import com.git.sweetmanager.dashboard.domain.model.queries.monthlychart.GetMonthlyChartByIdQuery;
import com.git.sweetmanager.dashboard.domain.services.monthlychart.MonthlyChartCommandService;
import com.git.sweetmanager.dashboard.domain.services.monthlychart.MonthlyChartQueryService;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.monthlychart.CreateMonthlyChartResource;
import com.git.sweetmanager.dashboard.interfaces.rest.resources.monthlychart.MonthlyChartResource;
import com.git.sweetmanager.dashboard.interfaces.rest.transform.monthlychart.CreateMonthlyChartCommandFromResourceAssembler;
import com.git.sweetmanager.dashboard.interfaces.rest.transform.monthlychart.MonthlyChartResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/monthlycharts", produces = MediaType.APPLICATION_JSON_VALUE)
public class MonthlyChartController {
    private final MonthlyChartQueryService monthlyChartQueryService;
    private final MonthlyChartCommandService monthlyChartCommandService;

    public MonthlyChartController(MonthlyChartQueryService monthlyChartQueryService, MonthlyChartCommandService monthlyChartCommandService) {
        this.monthlyChartQueryService = monthlyChartQueryService;
        this.monthlyChartCommandService = monthlyChartCommandService;
    }

    @PostMapping
    public ResponseEntity<MonthlyChartResource> createMonthlyChart(@RequestBody CreateMonthlyChartResource resource){
        var createMonthlyChartCommand = CreateMonthlyChartCommandFromResourceAssembler.toCommandFromResource(resource);
        var monthlyChart = monthlyChartCommandService.handle(createMonthlyChartCommand);
        if(monthlyChart.isEmpty()) return ResponseEntity.badRequest().build();
        var monthlyChartResource = MonthlyChartResourceFromEntityAssembler.toResourceFromEntity(monthlyChart.get());
        return new ResponseEntity<>(monthlyChartResource, HttpStatus.CREATED);
    }

    @GetMapping("/{monthlyChartId}")
    public ResponseEntity<MonthlyChartResource> getMonthlyChart(@PathVariable Long monthlyChartId){
        var getMonthlyChartByIdQuery = new GetMonthlyChartByIdQuery(monthlyChartId);
        var monthlyChart = monthlyChartQueryService.handle(getMonthlyChartByIdQuery);
        if(monthlyChart.isEmpty()) return ResponseEntity.badRequest().build();
        var monthlyChartResource = MonthlyChartResourceFromEntityAssembler.toResourceFromEntity(monthlyChart.get());
        return new ResponseEntity<>(monthlyChartResource, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MonthlyChartResource>> getAllMonthlyCharts(){
        var getAllMonthlyChartsQuery = new GetAllMonthlyChartsQuery();
        var monthlyCharts = monthlyChartQueryService.handle(getAllMonthlyChartsQuery);
        var monthlyChartResources = monthlyCharts.stream()
                .map(MonthlyChartResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return new ResponseEntity<>(monthlyChartResources, HttpStatus.OK);
    }
}