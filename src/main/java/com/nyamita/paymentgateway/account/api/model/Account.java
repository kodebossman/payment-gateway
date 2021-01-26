package com.nyamita.paymentgateway.account.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Account", indexes = {@Index(name = "indx_account", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Account {
  @Id
  private Long id;
  @Column(name = "accountnumber", nullable = false, length = 45)
  private String accountNumber;
  @Column(name = "accountbalance", nullable = false)
  private double accountBalance;
  @Column(name = "accountdescription", nullable = false)
  private String accountDescription;
  @Column(name = "updatedate", nullable = false)
  private LocalDate updateDate;
  @Column(name = "accountholder", nullable = false)
  private  String accountHolder;
  @Column(name = "destinationaccount", nullable = false)
  private String destinationAccount;
  @Column(name = "accountissuerbank", nullable = false, length = 45)
  private String accountIssuerBank;

}
