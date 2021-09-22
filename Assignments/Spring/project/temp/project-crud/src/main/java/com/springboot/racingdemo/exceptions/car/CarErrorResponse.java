package com.springboot.racingdemo.exceptions.car;

import lombok.Data;

@Data
public class CarErrorResponse {
    private String message;
    private long timestamp;
    public CarErrorResponse()
    {

    }
    public CarErrorResponse(String message, long timestamp)
    {
        this.message=message;
        this.timestamp=timestamp;
    }
}
