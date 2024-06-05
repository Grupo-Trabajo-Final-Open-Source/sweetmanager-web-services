package com.git.sweetmanager.rooms.domain.model.aggregates;

import com.git.sweetmanager.rooms.domain.model.commands.CreateBedroomCommand;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bedroom {

    @Getter
    private Long id;
    private final int typeBedroomId;
    private final int workerId;
    private final int totalBeds;
    private final int totalBathroom;
    private final int totalTelevision;
    private final String state;

    public Bedroom()
    {
        this.id = 0L;
        this.typeBedroomId = 0;
        this.workerId = 0;
        this.totalBeds = 0;
        this.totalBathroom = 0;
        this.totalTelevision = 0;
        this.state = "";
    }
    public Bedroom(int type_bedroom_id, int worker_id, int totalBeds,
                   int totalBathroom, int totalTelevision, String state){
        this.typeBedroomId = type_bedroom_id;
        this.workerId = worker_id;
        this.totalBeds = totalBeds;
        this.totalBathroom = totalBathroom;
        this.totalTelevision = totalTelevision;
        this.state = state;
    }

    public Bedroom(CreateBedroomCommand command)
    {
        this.typeBedroomId = command.typeBedroomId();
        this.workerId = command.workerId();
        this.totalBeds = command.totalBeds();
        this.totalBathroom = command.totalBathroom();
        this.totalTelevision = command.totalTelevision();
        this.state = command.state();
    }

    public Long GetId() { return id; }
    public int GetTypeBedroomId() { return typeBedroomId; }
    public int GetWorkerId() { return workerId; }
    public int GetTotalBeds() { return totalBeds; }
    public int GetTotalBathroom() { return totalBathroom; }
    public int GetTotalTelevision() { return totalTelevision; }
    public String GetState() { return state; }
}