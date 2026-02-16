package com.edu.Institiute.dto;

import com.edu.Institiute.entity.Employee;
import com.edu.Institiute.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyorDto {
    private String surveyorId;
    private String surveyorLicenseNumber;
    private Date surveyorLicenseExpiryDate;
    private String surveyorSpecialization;
    private String surveyorRank;
    private EmployeeDto Employee;
    private StatusDto Status;

}
