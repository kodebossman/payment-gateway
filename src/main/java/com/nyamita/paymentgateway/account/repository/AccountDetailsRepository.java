package com.nyamita.paymentgateway.account.repository;

import com.nyamita.paymentgateway.account.AccountDetails;
import com.nyamita.paymentgateway.account.dto.CreateTransactionDTO;
import com.nyamita.paymentgateway.account.dto.TransactionDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDetailsRepository  extends JpaRepository<AccountDetails,Long> {

  AccountDetails findByAccountNumberAndCurrentAccountBalanceAndDateTime

}
