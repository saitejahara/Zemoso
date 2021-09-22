package com.springboot.racingdemo.exceptions.driver;

import lombok.Data;

@Data
public class DriverErrorResponse {
    private String message;
    private long timestamp;
    public DriverErrorResponse()
    {

    }
    public DriverErrorResponse(String message, long timestamp)
    {
        this.message=message;
        this.timestamp=timestamp;
    }
}
