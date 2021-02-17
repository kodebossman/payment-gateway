package com.nyamita.paymentgateway.account.service;

import com.nyamita.paymentgateway.account.dto.CreateTransactionDTO;
import com.nyamita.paymentgateway.account.dto.TransactionDTO;
import com.nyamita.paymentgateway.common.exceptions.AccountNotFoundException;
import com.nyamita.paymentgateway.common.exceptions.LowBalanceException;

public interface AccountDetailsService {

   TransactionDTO createTransaction(CreateTransactionDTO createTransactionDTO) throws AccountNotFoundException, LowBalanceException;

}
