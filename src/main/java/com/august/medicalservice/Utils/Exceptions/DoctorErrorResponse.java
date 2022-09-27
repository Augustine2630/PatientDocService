package com.august.medicalservice.Utils.Exceptions;

public class DoctorErrorResponse {

    private  String message;

    private Long timestamp;

    public DoctorErrorResponse(String message, Long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
