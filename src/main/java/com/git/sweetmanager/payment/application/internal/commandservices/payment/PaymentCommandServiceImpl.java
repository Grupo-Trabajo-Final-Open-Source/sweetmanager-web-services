package com.git.sweetmanager.payment.application.internal.commandservices.payment;

import com.git.sweetmanager.payment.domain.model.aggregates.Payment;
import com.git.sweetmanager.payment.domain.model.commands.payment.CreatePaymentCommand;
import com.git.sweetmanager.payment.domain.services.payment.PaymentCommandService;
import com.git.sweetmanager.payment.infrastructure.persistence.mongo.repositories.payment.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {
    private final PaymentRepository paymentRepository;

    public PaymentCommandServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> handle(CreatePaymentCommand command) {

        if(command.idTitular() == 0) {
            throw new IllegalArgumentException("IdTitular cannot be zero");
        }
        if(command.titularName() == null || command.titularName().isEmpty()) {
            throw new IllegalArgumentException("IdPayment cannot be null or empty");
        }
        if(command.targetAccount() == null || command.targetAccount().isEmpty()) {
            throw new IllegalArgumentException("TargetAccount cannot be null or empty");
        }
        if(command.expirationDate() == null || command.expirationDate().isEmpty()) {
            throw new IllegalArgumentException("ExpirationDate cannot be null or empty");
        }
        if(command.cvc() == 0) {
            throw new IllegalArgumentException("Cvc cannot be zero");
        }
        if(command.email() == null || command.email().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        return Optional.of(new Payment(command));
    }
}
