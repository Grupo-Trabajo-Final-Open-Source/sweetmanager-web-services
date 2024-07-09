package com.git.sweetmanager.rooms.domain.model.aggregates;

import com.git.sweetmanager.rooms.domain.model.commands.CreateBedroomCommand;
import com.git.sweetmanager.rooms.domain.model.commands.UpdateBedroomCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bedrooms")
public class Bedroom extends AuditableAbstractAggregateRoot<Bedroom> {

    @Getter
    private String workerName;

    @Getter
    private String clientName;

    @Getter
    private int totalBeds;

    @Getter
    private int totalBathroom;

    @Getter
    private int totalTelevision;

    @Getter
    private String state;

    @Getter
    private String name;

    @Getter
    private String description;

    @Getter
    private Double price;

    public Bedroom()
    {
        this.workerName = "";
        this.totalBeds = 0;
        this.totalBathroom = 0;
        this.totalTelevision = 0;
        this.state = "";
    }
    public Bedroom(String worker, int totalBeds,
                   int totalBathroom, int totalTelevision, String state, String name, String description, Double price, String clientName){
        this.workerName = worker;
        this.totalBeds = totalBeds;
        this.totalBathroom = totalBathroom;
        this.totalTelevision = totalTelevision;
        this.state = state;
        this.name = name;
        this.description = description;
        this.price = price;
        this.clientName = clientName;
    }

    public Bedroom(CreateBedroomCommand command)
    {
        this.workerName = command.worker();
        this.totalBeds = command.totalBeds();
        this.totalBathroom = command.totalBathroom();
        this.totalTelevision = command.totalTelevision();
        this.state = command.state();
        this.name = command.name();
        this.description = command.description();
        this.price = command.price();
        this.clientName = command.clientName();
    }
    public Bedroom(UpdateBedroomCommand command)
    {
        this.setId(command.id());
        this.workerName = command.worker();
        this.totalBeds = command.totalBeds();
        this.totalBathroom = command.totalBathroom();
        this.totalTelevision = command.totalTelevision();
        this.state = command.state();
        this.name = command.name();
        this.description = command.description();
        this.price = command.price();
        this.clientName = command.clientName();
    }
}