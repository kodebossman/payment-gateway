package com.nyamita.paymentgateway.payment.api.model.service;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.account.repository.AccountRepository;
import com.nyamita.paymentgateway.account.service.AccountService;
import com.nyamita.paymentgateway.payment.api.model.Payment;
import com.nyamita.paymentgateway.payment.api.model.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class PaymentServiceImpl implements PaymentService {


  private final PaymentRepository paymentRepository;


  public PaymentServiceImpl(PaymentRepository paymentRepository){
    this.paymentRepository= paymentRepository;
  }

  @Override
  public Payment register(Payment payment) {

    log.info("Register a payment :{}"+payment);
    return paymentRepository.save(payment);
  }

    @Override
    public Optional<Payment> findByPaymentReference(String paymentReference) {
        return paymentRepository.findByPaymentReference(paymentReference);
    }

    @Override
    public List<Payment> findAllPayment() {

        log.debug("Getting all payments {}:");
        return paymentRepository.findAll();

}
}
