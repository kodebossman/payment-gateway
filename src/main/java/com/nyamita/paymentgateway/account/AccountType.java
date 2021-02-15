package com.nyamita.paymentgateway.account;

public enum AccountType {
  CURRENTACC(1),
  COMMECIALACC(2),
  STUDENTACC(3),
  SAVINGSACC(4),
  BUSSINESSACC(5),
  MERCHANTACC(6);

  AccountType( int accountType){
    this.accountType = accountType;
  }

  private int accountType;

  public int getAccountType(){
    return accountType;
  }
//  public AccountType getAccountType(int accountType){
//
//    return AccountType.AccountType(accountType);
//  }
}
