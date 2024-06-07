package com.git.sweetmanager.profile.domain.model.aggregates;

import com.git.sweetmanager.profile.domain.model.commands.customer.CreateCustomerCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer extends AuditableAbstractAggregateRoot<Customer> {

    // Attributes
    private String name;
    private String dni;
    private int age;
    private String email;

    // Constructors
    public Customer(String name, String dni, int age, String email){
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.email = email;
    }

    public Customer(CreateCustomerCommand command) {
        this.name = command.name();
        this.dni = command.dni();
        this.age = command.age();
        this.email = command.email();
    }

    public Customer(){

    }

    // Methods
    public void updateName(String name){
        this.name = name;
    }

    public void updateDni(String dni){
        this.dni = dni;
    }

    public void updateAge(int age){
        this.age = age;
    }

    public void updateEmail(String email){
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}