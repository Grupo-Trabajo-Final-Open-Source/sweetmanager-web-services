package com.git.sweetmanager.payment.interfaces.rest.transform.payment;

import com.git.sweetmanager.payment.domain.model.commands.payment.CreatePaymentCommand;

public class CreatePaymentCommandFromResourceAssembler {
    public static CreatePaymentCommand toCommandFromResource(CreatePaymentCommand resource) {
        return new CreatePaymentCommand(resource.idTitular(), resource.titularName(), resource.targetAccount(), resource.expirationDate(), resource.cvc(), resource.email());
    }

}
