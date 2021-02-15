package com.nyamita.paymentgateway.account.repository;

import com.nyamita.paymentgateway.account.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDetailsRepository  extends JpaRepository<AccountDetails,Long> {
}
