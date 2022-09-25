package com.august.medicalservice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "security_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private int yearOfBirth;
    @Column(nullable = false)
    private String password;

    private String role;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @JsonManagedReference
    private List<PatientData> patientDatas = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @JsonManagedReference
    private Set<DoctorData> doctorDatas = new LinkedHashSet<>();

    public Set<DoctorData> getDoctorDatas() {
        return doctorDatas;
    }

    public void setDoctorDatas(Set<DoctorData> doctorDatas) {
        this.doctorDatas = doctorDatas;
    }

    public List<PatientData> getPatientDatas() {
        return patientDatas;
    }

    public void setPatientDatas(List<PatientData> patientDatas) {
        this.patientDatas = patientDatas;
    }

    public User() {
    }

    public User(String username, int yearOfBirth) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
