package com.springboot.racingdemo.exceptions.car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CarErrorResponse> handleException(CarNotFoundException exception)
    {
        CarErrorResponse errorResponse=new CarErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<CarErrorResponse> handleException(Exception exception)
    {
        CarErrorResponse errorResponse=new CarErrorResponse();
        errorResponse.setTimestamp(System.currentTimeMillis());
        errorResponse.setMessage(exception.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
