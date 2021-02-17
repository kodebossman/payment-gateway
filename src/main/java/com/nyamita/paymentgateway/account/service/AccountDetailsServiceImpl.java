package com.nyamita.paymentgateway.account.service;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.account.AccountDetails;
import com.nyamita.paymentgateway.account.dto.CreateTransactionDTO;
import com.nyamita.paymentgateway.account.dto.TransactionDTO;
import com.nyamita.paymentgateway.account.repository.AccountDetailsRepository;
import com.nyamita.paymentgateway.account.repository.AccountRepository;
import com.nyamita.paymentgateway.common.exceptions.AccountNotFoundException;
import com.nyamita.paymentgateway.common.exceptions.LowBalanceException;
import com.nyamita.paymentgateway.common.exceptions.RecordNotFoundException;
import com.nyamita.paymentgateway.transaction.Transaction;
import com.nyamita.paymentgateway.transaction.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
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
  public TransactionDTO createTransaction(CreateTransactionDTO createTransactionDTO) throws AccountNotFoundException, LowBalanceException {

    log.info("CreateTransactionDTO {}" + createTransactionDTO);

    if(checkAccount(createTransactionDTO.getAccountNumber())){

      double transAmount = createTransactionDTO.getTransaction().getAmount();
      double transactionCharges = transAmount* 0.01;
      //TODO - send transaction charges to gateway account

      //check that the ammount+ charges in transaction is not greater than currentbalance
      double totalAmount = transAmount + transactionCharges;

      List<AccountDetails> accountDetails = accountDetailsRepository.findByAccountNumberOrderByIdDateTimeDesc(createTransactionDTO.getAccountNumber());
      Optional<AccountDetails> currentAccDetails = accountDetails.stream().findFirst();

      if( currentAccDetails.isPresent()) {

        double currentAccBalance = accountDetails.get(0).getCurrentAccountBalance();
        if (totalAmount > currentAccBalance && !createTransactionDTO.getTransaction().getTransactionType().equals("Deposit")) {

          // if transaction
          throw new LowBalanceException("Amount not good enough please reload your account");
        }

        //check the destination account exist??

        //TODO- (call bank name to verify the account)

        AccountDetails accountDetail = new AccountDetails();
        accountDetail.setAccountNumber(createTransactionDTO.getAccountNumber());
        //check transactionType
        double currentAccBal = currentAccBalance - totalAmount;
        accountDetail.setCurrentAccountBalance(currentAccBal);
        accountDetail.setPreviousBalance(currentAccBalance);
        accountDetail.setDateTime(LocalDateTime.now());
        AccountDetails accDetail =  accountDetailsRepository.save(accountDetail);

        //save transaction

        Transaction transaction = new Transaction();
        transaction.setAccountDetailsId(accDetail.getId());
        transaction.setAmount(createTransactionDTO.getTransaction().getAmount());
        transaction.setDestinationAccNumber(createTransactionDTO.getTransaction().getDestinationAccNumber());
        transaction.setDestinationBank(createTransactionDTO.getTransaction().getDestinationBank());
        transaction.setReference(createTransactionDTO.getTransaction().getReference());
        transaction.setTransactionCharges(transactionCharges);
        transaction.setTransactionType(createTransactionDTO.getTransaction().getTransactionType());

        Transaction trans = transactionRepository.save(transaction);

        // created Transaction DTO
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAccountNumber(accDetail.getAccountNumber());
        transactionDTO.setCurrentAccountBalance(accDetail.getCurrentAccountBalance());
        transactionDTO.setDateTime(accDetail.getDateTime());
        transactionDTO.setPreviousBalance(accDetail.getPreviousBalance());
        transactionDTO.setTransaction(trans);

        return transactionDTO;
      }


    }else {
      throw new AccountNotFoundException(" The account does not exit");
    }

    return new TransactionDTO();
  }

  public boolean checkAccount(String accountNumber) {

    Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
    if (!account.isPresent()) {
      return false;
    }
    return true;
  }
}
