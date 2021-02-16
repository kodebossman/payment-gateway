package com.nyamita.paymentgateway.account.service;

import com.nyamita.paymentgateway.account.dto.CreateTransactionDTO;
import com.nyamita.paymentgateway.account.dto.TransactionDTO;

public interface AccountDetailsService {

   TransactionDTO createTransaction(CreateTransactionDTO createTransactionDTO);

}
