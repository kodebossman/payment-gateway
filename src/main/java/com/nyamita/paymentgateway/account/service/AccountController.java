package com.nyamita.paymentgateway.account.service;

import com.nyamita.paymentgateway.account.Account;
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
@RequestMapping("/account")
public class AccountController {

  private final AccountService accountService;

  private AccountController (AccountService accountService){
    this.accountService = accountService;
  }

  @PostMapping(value="/create")

  public ResponseEntity<Account> register(@Valid @RequestBody Account account){

    log.info("Account is{}: " +account);
    Account acc = accountService.register(account);
    return new ResponseEntity<>(acc,HttpStatus.CREATED);
  }




}
