package com.git.sweetmanager.payment.domain.services.payment;

import com.git.sweetmanager.payment.domain.model.aggregates.Payment;
import com.git.sweetmanager.payment.domain.model.queries.payment.GetAllPaymentsQuery;
import com.git.sweetmanager.payment.domain.model.queries.payment.GetPaymentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PaymentQueryService {
    List<Payment> handle(GetAllPaymentsQuery query);

    Optional<Payment> handle(GetPaymentByIdQuery query);

}
