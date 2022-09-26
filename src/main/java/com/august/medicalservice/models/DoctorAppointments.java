package com.august.medicalservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "doctor_appointments")
public class DoctorAppointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "reception_time")
    private String receptionTime;

    @Column(name = "is_recorded")
    private Boolean isRecorded;

    @Column(name = "who_recorded")
    private String whoRecorded;

    @ManyToOne
    @JoinColumn(name = "doctor_data_doctor_id")
    @JsonBackReference
    private DoctorData doctorData;

    public String getWhoRecorded() {
        return whoRecorded;
    }

    public void setWhoRecorded(String whoRecorded) {
        this.whoRecorded = whoRecorded;
    }

    public Boolean getIsRecorded() {
        return isRecorded;
    }

    public void setIsRecorded(Boolean isRecorded) {
        this.isRecorded = isRecorded;
    }

    public String getReceptionTime() {
        return receptionTime;
    }

    public void setReceptionTime(String receptionTime) {
        this.receptionTime = receptionTime;
    }

    public DoctorData getDoctorData() {
        return doctorData;
    }

    public void setDoctorData(DoctorData doctorData) {
        this.doctorData = doctorData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}