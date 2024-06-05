package com.git.sweetmanager.payment.domain.model.commands.payment;

public record CreatePaymentCommand(int idTitular, String titularName, String targetAccount, String expirationDate, int cvc, String email){

}
