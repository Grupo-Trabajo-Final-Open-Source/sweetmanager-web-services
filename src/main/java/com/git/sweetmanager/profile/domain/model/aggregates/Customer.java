package com.git.sweetmanager.profile.domain.model.aggregates;

import com.git.sweetmanager.profile.domain.model.commands.customer.CreateCustomerCommand;
import com.git.sweetmanager.profile.domain.model.commands.customer.UpdateCustomerCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer extends AuditableAbstractAggregateRoot<Customer> {

    // Attributes
    private String name;
    private String email;
    private String phoneNumber;
    private String reservationDate;
    private String reservationTime;
    private double cost;

    // Constructors
    public Customer(String name, String email, String phoneNumber, String reservationDate, String reservationTime, double cost){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.cost = cost;
    }

    public Customer(CreateCustomerCommand command) {
        this.name = command.name();
        this.email = command.email();
        this.phoneNumber = command.phoneNumber();
        this.reservationDate = command.reservationDate();
        this.reservationTime = command.reservationTime();
        this.cost = command.cost();
    }

    public Customer(UpdateCustomerCommand command) {
        this.setId(command.id());
        this.name = command.name();
        this.email = command.email();
        this.phoneNumber = command.phoneNumber();
        this.reservationDate = command.reservationDate();
        this.reservationTime = command.reservationTime();
        this.cost = command.cost();
    }

    public Customer(){

    }

    // Methods
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getReservationDate() {
        return reservationDate;
    }
    public String getReservationTime() {
        return reservationTime;
    }
    public double getCost() {
        return cost;
    }
}