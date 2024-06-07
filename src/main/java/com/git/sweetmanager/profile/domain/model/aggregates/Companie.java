package com.git.sweetmanager.profile.domain.model.aggregates;

import com.git.sweetmanager.profile.domain.model.commands.company.CreateCompanyCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "companies")
public class Companie extends AuditableAbstractAggregateRoot<Companie> {

    // Attributes
    private String businessName;
    private String ruc;

    // Constructors
    public Companie(String businessName, String ruc){
        this.businessName = businessName;
        this.ruc = ruc;
    }

    public Companie(CreateCompanyCommand command) {
        this.businessName = command.businessName();
        this.ruc = command.ruc();
    }

    public Companie(){

    }

    // Methods
    public void updateBusinessName(String businessName){
        this.businessName = businessName;
    }

    public void updateRUC(String ruc){
        this.ruc = ruc;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getRuc() {
        return ruc;
    }
}