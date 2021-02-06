package com.nyamita.paymentgateway.payment.api.model.service;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.payment.api.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

  Payment register(Payment payment);
  Optional<Payment> findByPaymentReference(String paymentReference);
  List<Payment> findAllPayment();

}
