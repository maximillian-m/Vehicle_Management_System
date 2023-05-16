package com.Maximillian.vehicle_parking_mgt_system.exception;

public class ResourceNotFoundException extends RuntimeException{
    protected String message;

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
