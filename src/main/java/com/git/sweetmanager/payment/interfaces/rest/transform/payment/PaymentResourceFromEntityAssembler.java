package com.git.sweetmanager.payment.interfaces.rest.transform.payment;

import com.git.sweetmanager.payment.domain.model.aggregates.Payment;
import com.git.sweetmanager.payment.interfaces.rest.resources.payment.PaymentResource;

public class PaymentResourceFromEntityAssembler {

    public static PaymentResource toResourceFromEntity(Payment entity) {
        return new PaymentResource(entity.getId(), entity.getIdTitular(), entity.getTitularName() ,entity.getTargetAccount(), entity.getExpirationDate(), entity.getCvc(), entity.getEmail());
    }
}
