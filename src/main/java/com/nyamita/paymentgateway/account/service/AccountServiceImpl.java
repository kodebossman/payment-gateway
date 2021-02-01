package com.nyamita.paymentgateway.account.service;

import com.nyamita.paymentgateway.account.Account;
import com.nyamita.paymentgateway.account.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

  //dependancy injection
  private final AccountRepository accountRepository;

  //constructor injection
  public AccountServiceImpl(AccountRepository accountRepository){
    this.accountRepository= accountRepository;
  }

  @Override
  public Account register(Account account) {

    log.info("Register an account :{}"+account);
    return accountRepository.save(account);
  }

}
