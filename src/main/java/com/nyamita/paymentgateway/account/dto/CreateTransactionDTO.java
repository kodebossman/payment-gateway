package com.nyamita.paymentgateway.account.dto;

import com.nyamita.paymentgateway.transaction.Transaction;
import lombok.Data;


import java.io.Serializable;

@Data
public class CreateTransactionDTO implements Serializable {

  private String accountNumber;
  private Transaction transaction;

}
