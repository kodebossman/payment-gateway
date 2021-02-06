package com.nyamita.paymentgateway.payment.api.model.api;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.account.service.AccountService;
import com.nyamita.paymentgateway.payment.api.model.Payment;
import com.nyamita.paymentgateway.payment.api.model.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

  private final PaymentService paymentService;

  private PaymentController(PaymentService paymentService){
    this.paymentService = paymentService;
  }

  @PostMapping(value="/createPayment")

  public ResponseEntity<Payment> register(@Valid @RequestBody Payment payment ){

    log.info("Payment is{}: " +payment);
    Payment py = paymentService.register(payment);
    return new ResponseEntity<>(py,HttpStatus.CREATED);
  }




}
