package com.git.sweetmanager.payment.interfaces.rest.resources.payment;

public record PaymentResource(Long id, int idTitular, String titularName, String targetAccount, String expirationDate, int cvc, String email) {
}
