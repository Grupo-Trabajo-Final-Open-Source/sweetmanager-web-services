package com.git.sweetmanager.payment.interfaces.rest.resources.payment;

public record CreatePaymentResource(int idTitular, String titularName, String targetAccount, String expirationDate, int cvc, String email) {
}
