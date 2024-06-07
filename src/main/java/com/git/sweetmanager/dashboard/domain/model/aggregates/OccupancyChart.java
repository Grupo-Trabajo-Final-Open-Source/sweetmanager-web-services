package com.git.sweetmanager.dashboard.domain.model.aggregates;

import com.git.sweetmanager.dashboard.domain.model.commands.occupancychart.CreateOccupancyChartCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "occupancyChart")
public class OccupancyChart extends AuditableAbstractAggregateRoot<OccupancyChart> {

    // Attributes
    private String roomType;
    private int total;

    // Constructors
    public OccupancyChart(String roomType, int total){
        this.roomType = roomType;
        this.total = total;
    }

    public OccupancyChart(CreateOccupancyChartCommand command) {
        this.roomType = command.roomType();
        this.total = command.total();
    }

    public OccupancyChart(){

    }

    // Methods
    public void updateRoomType(String roomType){
        this.roomType = roomType;
    }

    public void updateTotal(int total){
        this.total = total;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getTotal() {
        return total;
    }
}