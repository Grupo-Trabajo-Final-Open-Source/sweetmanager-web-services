package com.git.sweetmanager.rooms.domain.model.aggregates;

import com.git.sweetmanager.rooms.domain.model.commands.CreateBookingCommand;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Booking {

    @Getter
    private Long id;
    private final int clientId;
    private final int bedroomId;
    private final Date startDate;
    private final Date finalDate;
    private final float totalPrice;
    private final String state;

    public Booking()
    {
        this.id = 0L;
        this.clientId = 0;
        this.bedroomId = 0;
        this.startDate = new Date();
        this.finalDate = new Date();
        this.totalPrice = 0;
        this.state = "";
    }

    public Booking(int clientId, int bedroomId,
                   Date startDate, Date finalDate,
                   float totalPrice, String state)
    {
        this.clientId = clientId;
        this.bedroomId = bedroomId;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.totalPrice = totalPrice;
        this.state = state;
    }

    public Booking(CreateBookingCommand command)
    {
        this.clientId = command.clientId();
        this.bedroomId = command.bedroomId();
        this.startDate = command.startDate();
        this.finalDate = command.finalDate();
        this.totalPrice = command.totalPrice();
        this.state = command.state();
    }

    public Long GetId() { return id; }
    public int GetClientId() { return clientId; }
    public int GetBedroomId() { return bedroomId; }
    public Date GetStartDate() { return startDate; }
    public Date GetFinalDate() { return finalDate; }
    public float GetTotalPrice() { return totalPrice; }
    public String GetState() { return state; }
}