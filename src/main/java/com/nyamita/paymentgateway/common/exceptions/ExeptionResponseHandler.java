package com.nyamita.paymentgateway.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExeptionResponseHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  protected ResponseEntity<Object> exception(BadRequestException exception) {

    ErrorMessage errorMsg = new ErrorMessage(exception.getMessage(), 404, "range not defined");
    return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
  }


    @ExceptionHandler(RecordNotFoundException.class)
    protected ResponseEntity<Object> exception(RecordNotFoundException exception) {

        ErrorMessage errorMsg = new ErrorMessage(exception.getMessage(), 404, "Record not available");
        return new ResponseEntity<>(errorMsg, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    protected ResponseEntity<Object> exception(AccountNotFoundException exception) {

        ErrorMessage errorMsg = new ErrorMessage(exception.getMessage(), 404, "Account not available");
        return new ResponseEntity<>(errorMsg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LowBalanceException.class)
    protected ResponseEntity<Object> exception(LowBalanceException exception) {

        ErrorMessage errorMsg = new ErrorMessage(exception.getMessage(), 404, "Your balance is lower than the transaction amount");
        return new ResponseEntity<>(errorMsg, HttpStatus.NOT_ACCEPTABLE);
    }

}


