package com.git.sweetmanager.payment.domain.model.aggregates;

import com.git.sweetmanager.payment.domain.model.commands.CreateSubscriptionCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "subscriptions")
public class Subscription extends AuditableAbstractAggregateRoot<Subscription> {

    // Attributes

    private String title;

    private Double price;

    private String description;

    // Constructors

    public Subscription(String title, Double price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public Subscription(CreateSubscriptionCommand command){
        this.title = command.title();
        this.price = command.price();
        this.description = command.description();
    }

    // Methods

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
