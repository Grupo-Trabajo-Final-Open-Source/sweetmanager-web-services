package com.git.sweetmanager.payment.domain.model.aggregates;


import com.git.sweetmanager.payment.domain.model.commands.payment.CreatePaymentCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "payments")
public class Payment extends AuditableAbstractAggregateRoot<Payment> {
    private int idTitular;

    private String titularName;

    private String targetAccount;

    private String expirationDate;

    private int cvc;

    private String email;

    // Constructor
    public Payment(int idTitular, String titularName, String targetAccount, String expirationDate, int cvc, String email) {
        this.idTitular = idTitular;
        this.titularName = titularName;
        this.targetAccount = targetAccount;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.email = email;
    }

    public Payment(CreatePaymentCommand command){
        this.idTitular = command.idTitular();
        this.titularName = command.titularName();
        this.targetAccount = command.targetAccount();
        this.expirationDate = command.expirationDate();
        this.cvc = command.cvc();
        this.email = command.email();
    }

    public int getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(int idTitular) {
        this.idTitular = idTitular;
    }

    public String getTitularName() {
        return titularName;
    }

    public void setTitularName(String titularName) {
        this.titularName = titularName;
    }

    public String getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(String targetAccount) {
        this.targetAccount = targetAccount;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
