package com.nyamita.paymentgateway.account.service;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.account.AccountDetails;
import com.nyamita.paymentgateway.account.dto.CreateTransactionDTO;
import com.nyamita.paymentgateway.account.dto.TransactionDTO;
import com.nyamita.paymentgateway.account.repository.AccountDetailsRepository;
import com.nyamita.paymentgateway.account.repository.AccountRepository;
import com.nyamita.paymentgateway.common.exceptions.RecordNotFoundException;
import com.nyamita.paymentgateway.transaction.Transaction;
import com.nyamita.paymentgateway.transaction.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class AccountDetailsServiceImpl implements AccountDetailsService {

  //dependancy injection
  private final AccountDetailsRepository accountDetailsRepository;
  private final TransactionRepository transactionRepository;
  private final AccountRepository accountRepository;

  //constructor injection
  public AccountDetailsServiceImpl(AccountDetailsRepository accountDetailsRepository, TransactionRepository transactionRepository,
                                   AccountRepository accountRepository) {
    this.accountDetailsRepository = accountDetailsRepository;
    this.transactionRepository = transactionRepository;
    this.accountRepository = accountRepository;
  }

  @Override
  public TransactionDTO createTransaction(CreateTransactionDTO createTransactionDTO) {

    log.info("CreateTransactionDTO {}" + createTransactionDTO);

    if(checkAccount(createTransactionDTO.getAccountNumber())){

      double transAmount = createTransactionDTO.getTransaction().getAmount();
      double transactionCharges = transAmount* 0.01;
      //TODO - send transaction charges to gateway account

      double totalAmount = transAmount + transactionCharges;

      double currentBalance = accountDetailsRepository.






    }

    //check that this account exists

    //check that the ammount+ charges in transaction is not greater than currentbalance
    //check the destination account exist??
    //calculate the new current balance;
    //save the account details
    //save transaction
    // return transaction dto

    return null;
  }

  public boolean checkAccount(String accountNumber) {

    Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
    if (!account.isPresent()) {
      return false;
    }
    return true;
  }
}
