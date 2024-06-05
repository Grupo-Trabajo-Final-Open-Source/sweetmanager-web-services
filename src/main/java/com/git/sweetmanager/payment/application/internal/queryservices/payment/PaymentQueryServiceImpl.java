package com.git.sweetmanager.payment.application.internal.queryservices.payment;

import com.git.sweetmanager.payment.domain.model.aggregates.Payment;
import com.git.sweetmanager.payment.domain.model.queries.payment.GetAllPaymentsQuery;
import com.git.sweetmanager.payment.domain.model.queries.payment.GetPaymentByIdQuery;
import com.git.sweetmanager.payment.domain.services.payment.PaymentQueryService;
import com.git.sweetmanager.payment.infrastructure.persistence.mongo.repositories.payment.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {

    private final PaymentRepository paymentRepository;

    public PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> handle(GetAllPaymentsQuery query) {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> handle(GetPaymentByIdQuery query) {
        return paymentRepository.findById(query.paymentId());
    }
}
