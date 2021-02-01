package com.nyamita.paymentgateway.account.repository;

import com.nyamita.paymentgateway.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
