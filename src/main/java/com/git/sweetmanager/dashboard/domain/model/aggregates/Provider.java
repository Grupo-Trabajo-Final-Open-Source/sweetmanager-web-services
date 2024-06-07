package com.git.sweetmanager.dashboard.domain.model.aggregates;

import com.git.sweetmanager.dashboard.domain.model.commands.provider.CreateProviderCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "providers")
public class Provider extends AuditableAbstractAggregateRoot<Provider> {

    // Attributes
    private String name;
    private String contact;
    private String address;
    private String product;

    // Constructors
    public Provider(String name, String contact, String address, String product){
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.product = product;
    }

    public Provider(CreateProviderCommand command) {
        this.name = command.name();
        this.contact = command.contact();
        this.address = command.address();
        this.product = command.product();
    }

    public Provider(){

    }

    // Methods
    public void updateName(String name){
        this.name = name;
    }

    public void updateContact(String contact){
        this.contact = contact;
    }

    public void updateAddress(String address){
        this.address = address;
    }

    public void updateProduct(String product){
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getProduct() {
        return product;
    }
}