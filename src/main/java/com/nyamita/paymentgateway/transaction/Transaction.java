package com.nyamita.paymentgateway.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nyamita.paymentgateway.common.BaseEntity;
import com.nyamita.paymentgateway.common.enums.TransactionType;
import com.nyamita.paymentgateway.payment.api.model.Payment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transactions", indexes = {@Index(name = "indx_transaction", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Transaction extends BaseEntity {

  @Column(name = "amount", nullable = false)
  private double amount;
  @Column(name = "charges", nullable = false)
  private Double transactionCharges;
  @Column(name = "transactiontype", nullable = false)
  private TransactionType transactionType;
  @Column(name = "reference", nullable = false, length = 50)
  private String reference;
  @Column(name = "accountnumber", nullable = false, length = 12)
  private String destinationAccNumber;
  @Column(name = "destinationBank", nullable = false, length = 50)
  private String destinationBank;
  @Column(name = "accountDetailId", nullable = false)
  private int accountDetailsId;

}