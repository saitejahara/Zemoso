package com.springboot.racingdemo.exceptions.driver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DriverExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<DriverErrorResponse> handleException(DriverNotFoundException exception)
    {
        DriverErrorResponse errorResponse=new DriverErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<DriverErrorResponse> handleException(Exception exception)
    {
        DriverErrorResponse errorResponse=new DriverErrorResponse();
        errorResponse.setTimestamp(System.currentTimeMillis());
        errorResponse.setMessage(exception.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
