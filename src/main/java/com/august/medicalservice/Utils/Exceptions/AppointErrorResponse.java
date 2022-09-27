package com.august.medicalservice.Utils.Exceptions;

public class AppointErrorResponse {

    private String message;

    private String timestamp;

    public AppointErrorResponse(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
