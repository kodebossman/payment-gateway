package com.nyamita.paymentgateway.client;

import javax.persistence.Id;

public class Client {

  @Id
  private Long id;
  private String name;
  private String surmane;
  private String address;
  private String emailAdress;
  private String phoneNumber;
  private  String gender;
  private String proffession;
  private String customerType;
}
