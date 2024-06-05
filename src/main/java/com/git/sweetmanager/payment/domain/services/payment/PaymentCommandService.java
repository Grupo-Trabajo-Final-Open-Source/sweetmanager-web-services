package com.git.sweetmanager.payment.domain.services.payment;

import com.git.sweetmanager.payment.domain.model.aggregates.Payment;
import com.git.sweetmanager.payment.domain.model.commands.payment.CreatePaymentCommand;

import java.util.Optional;

public interface PaymentCommandService {
    Optional<Payment> handle(CreatePaymentCommand command);

}
