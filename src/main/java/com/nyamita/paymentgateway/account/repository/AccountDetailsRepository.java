package com.nyamita.paymentgateway.account.repository;

import com.nyamita.paymentgateway.account.AccountDetails;
import com.nyamita.paymentgateway.account.dto.CreateTransactionDTO;
import com.nyamita.paymentgateway.account.dto.TransactionDTO;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountDetailsRepository  extends JpaRepository<AccountDetails,Long> {

  List<AccountDetails> findByAccountNumberOrderByIdDateTimeDesc(String accountNumber);

}
