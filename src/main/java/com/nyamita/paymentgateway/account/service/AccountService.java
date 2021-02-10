package com.nyamita.paymentgateway.account.service;

import com.nyamita.paymentgateway.account.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService  {

  Account register(Account account);
  Optional<Account> findByAccountNumber(String accountNumber);
  List<Account> findAllAccount();
  Account update ( Account account);
  void delete(Long Id);

}
