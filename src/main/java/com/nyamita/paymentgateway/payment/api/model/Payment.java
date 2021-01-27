package com.nyamita.paymentgateway.payment.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nyamita.paymentgateway.transaction.Transaction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payments", indexes = {@Index(name = "indx_payment", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Payment {
  @Id
  private Long id;
  @Column(name = "paymentid", nullable = false, length = 45)
  private String paymentId;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn(name="transation_id")
  private Transaction transaction;

  @Column(name = "paymentamount", nullable = false)
  private double paymentAmount;
  @Column(name = "paymentreference", nullable = false, length = 45)
  private String paymentReference;
  @Column(name = "paymentdate", nullable = false)
  private LocalDate paymentDate;
  @Column(name = "accountholder", nullable = false)
  private  String accountHolder;
  @Column(name = "accountnumber", nullable = false)
  private String accountNumber;
  @Column(name = "destinationaccount", nullable = false)
  private String destinationAccount;
  @Column(name = "issuersenderbank", nullable = false, length = 45)
  private String issuerSenderBank;

}
