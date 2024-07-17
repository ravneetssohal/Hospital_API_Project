package com.pragra.hospitalmicroserviceravneet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDTO {
    private Integer nurseID;
    private String nurseFirstName;
    private String nurseLastName;
    private String nursePassword;
    private String nursePhoneNo;
    private Integer nurseSalary;
}
