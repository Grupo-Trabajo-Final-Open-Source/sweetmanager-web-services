package com.git.sweetmanager.supply.domain.model.aggregates;

import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import com.git.sweetmanager.supply.domain.model.commands.CreateSupplyCommand;
import com.git.sweetmanager.supply.domain.model.commands.UpdateSupplyCommand;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "supplies")
public class Supplie extends AuditableAbstractAggregateRoot<Supplie> {
    // Attributes
    private String product;
    private Number quantity;
    private String address;
    private String expire;

    // Constructors

    public Supplie(){

    }

    public Supplie(String product, Number quantity, String address, String expire) {
        this.product = product;
        this.quantity = quantity;
        this.address = address;
        this.expire = expire;
    }
    public Supplie(CreateSupplyCommand command) {
        this.product = command.product();
        this.quantity = command.quantity();
        this.address = command.address();
        this.expire = command.expire();
    }

    public Supplie(UpdateSupplyCommand command){
        this.setId(command.id());
        this.product = command.product();
        this.quantity = command.quantity();
        this.address = command.address();
        this.expire = command.expire();
    }

    // Methods

    public String getProduct() {
        return product;
    }
    public Number getQuantity() {
        return quantity;
    }
    public String getAddress() {
        return address;
    }
    public String getExpire() {
        return expire;
    }
}