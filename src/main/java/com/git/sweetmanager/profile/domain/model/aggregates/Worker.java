package com.git.sweetmanager.profile.domain.model.aggregates;

import com.git.sweetmanager.profile.domain.model.commands.worker.CreateWorkerCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "workers")
public class Worker extends AuditableAbstractAggregateRoot<Worker> {

    // Attributes
    private String name;
    private String email;
    private String company;
    private String role;
    private String password;

    // Constructors
    public Worker(String name, String email, String company, String role, String password){
        this.name = name;
        this.email = email;
        this.company = company;
        this.role = role;
        this.password = password;
    }

    public Worker(CreateWorkerCommand command) {
        this.name = command.name();
        this.email = command.email();
        this.company = command.company();
        this.role = command.role();
        this.password = command.password();
    }

    public Worker(){

    }

    // Methods
    public void updateName(String name){
        this.name = name;
    }

    public void updateEmail(String email){
        this.email = email;
    }

    public void updateCompany(String company){
        this.company = company;
    }

    public void updateRole(String role){
        this.role = role;
    }

    public void updatePassword(String password){
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}