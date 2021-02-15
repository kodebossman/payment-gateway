package com.nyamita.paymentgateway.account.dto;

import com.nyamita.paymentgateway.transaction.Transaction;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TransactionDTO implements Serializable {
  private String accountNumber;
  private double currentAccountBalance;
  private double previousBalance;
  private LocalDateTime dateTime;
  private Transaction transaction;

}
