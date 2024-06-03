package com.git.sweetmanager.rooms.domain.model.aggregates;

import com.git.sweetmanager.rooms.domain.model.commands.CreateBedroomCommand;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bedroom {

    @Getter
    private int id;
    private int type_bedroom_id;
    private int worker_id;
    private int totalBeds;
    private int totalBathroom;
    private int totalTelevision;
    private String state;

    public Bedroom()
    {
        this.id = 0;
        this.type_bedroom_id = 0;
        this.worker_id = 0;
        this.totalBeds = 0;
        this.totalBathroom = 0;
        this.totalTelevision = 0;
        this.state = "";
    }
    public Bedroom(int type_bedroom_id, int worker_id, int totalBeds,
                   int totalBathroom, int totalTelevision, String state){
        this.type_bedroom_id = type_bedroom_id;
        this.worker_id = worker_id;
        this.totalBeds = totalBeds;
        this.totalBathroom = totalBathroom;
        this.totalTelevision = totalTelevision;
        this.state = state;
    }

    public Bedroom(CreateBedroomCommand command)
    {
        this.type_bedroom_id = command.type_bedroom_id();
        this.worker_id = command.worker_id();
        this.totalBeds = command.totalBeds();
        this.totalBathroom = command.totalBathroom();
        this.totalTelevision = command.totalTelevision();
        this.state = command.state();
    }

    public int GetId() { return id; }
    public int GetTypeBedroomId() { return type_bedroom_id; }
    public int GetWorkerId() { return worker_id; }
    public int GetTotalBeds() { return totalBeds; }
    public int GetTotalBathroom() { return totalBathroom; }
    public int GetTotalTelevision() { return totalTelevision; }
    public String GetState() { return state; }
}