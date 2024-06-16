package com.git.sweetmanager.rooms.domain.model.aggregates;

import com.git.sweetmanager.rooms.domain.model.commands.CreateBookingCommand;
import com.git.sweetmanager.rooms.domain.model.commands.UpdateBookingCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import lombok.Getter;
import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "bookings")
public class Booking extends AuditableAbstractAggregateRoot<Booking> {

    private int clientId;
    private int bedroomId;
    private LocalDate startDate;
    private LocalDate finalDate;
    private float totalPrice;
    private String state;

    public Booking()
    {
    }

    public Booking(int clientId, int bedroomId,
                   LocalDate startDate, LocalDate finalDate,
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

    public Booking(UpdateBookingCommand command)
    {
        this.clientId = command.clientId();
    }

    public int GetClientId() { return clientId; }
    public int GetBedroomId() { return bedroomId; }
    public LocalDate GetStartDate() { return startDate; }
    public LocalDate GetFinalDate() { return finalDate; }
    public float GetTotalPrice() { return totalPrice; }
    public String GetState() { return state; }
}