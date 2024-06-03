package com.git.sweetmanager.communication.domain.model.aggregates;

import com.git.sweetmanager.communication.domain.model.commands.CreateNotificationCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "notifications")
public class Notification extends AuditableAbstractAggregateRoot<Notification> {

    // Attributes

    @Id
    private Long _id;

    private String  title;

    private LocalDate date;

    private String message;

    // Constructors
    public Notification(String title, LocalDate date, String message){
        this.title = title;
        this.date = date;
        this.message = message;
    }

    public Notification(CreateNotificationCommand command) {
        this.title = command.title();
        this.date = command.date();
        this.message = command.message();
    }

    public Notification(){

    }

    // Methods
    public void updateTitle(String title){
        this.title = title;
    }

    public void updateDate(LocalDate date){
        this.date = date;
    }

    public void updateMessage(String message){
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

}
