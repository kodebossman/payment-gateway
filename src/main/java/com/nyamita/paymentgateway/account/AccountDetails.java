package com.nyamita.paymentgateway.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nyamita.paymentgateway.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accountdetails", indexes = {@Index(name = "indx_accountdetails", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class AccountDetails extends BaseEntity {

  private String accountNumber;
  private double currentAccountBalance;
  private double previousBalance;
  private LocalDateTime dateTime;


}
