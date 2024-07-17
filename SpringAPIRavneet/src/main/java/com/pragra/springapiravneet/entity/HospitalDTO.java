package com.pragra.springapiravneet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HospitalDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nurseID;
    private String nurseFirstName;
    private String nurseLastName;
    private String nursePassword;
    private String nursePhoneNo;
    private Integer nurseSalary;
}
