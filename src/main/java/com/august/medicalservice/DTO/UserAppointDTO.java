package com.august.medicalservice.DTO;

import javax.validation.constraints.NotEmpty;

public class UserAppointDTO {

    @NotEmpty
    private Boolean isRecorded;

    @NotEmpty
    private String whoRecorded;

    public Boolean getRecorded() {
        return isRecorded;
    }

    public void setRecorded(Boolean recorded) {
        isRecorded = recorded;
    }

    public String getWhoRecorded() {
        return whoRecorded;
    }

    public void setWhoRecorded(String whoRecorded) {
        this.whoRecorded = whoRecorded;
    }
}
