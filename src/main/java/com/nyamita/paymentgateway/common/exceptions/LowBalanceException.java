package com.nyamita.paymentgateway.common.exceptions;

public class LowBalanceException extends Exception {
    public LowBalanceException(String message){
        super(message);
    }
}
