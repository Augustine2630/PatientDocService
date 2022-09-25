package com.august.medicalservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class PatientData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "first_name", nullable = false)
    @NotEmpty
    @Size(min = 1, max = 30, message = "Name must be between 1 and 30 characters")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotEmpty
    @Size(min = 1, max = 30, message = "Surname must be between 1 and 30 characters")
    private String lastName;

    @Column(name = "email", nullable = false)
    @Email
    @NotEmpty
    @Size(min = 4, message = "email must be at least 5 characters")
    private String email;

    @Column(name = "patient_data", nullable = true)
    private String patientData;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatientData() {
        return patientData;
    }

    public void setPatientData(String patientData) {
        this.patientData = patientData;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

