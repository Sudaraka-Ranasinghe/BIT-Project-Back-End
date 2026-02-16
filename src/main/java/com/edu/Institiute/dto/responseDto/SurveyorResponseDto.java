package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.EmployeeDto;
import com.edu.Institiute.dto.StatusDto;
import com.edu.Institiute.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyorResponseDto {
    private String surveyorId;
    private String surveyorLicenseNumber;
    private Date surveyorLicenseExpiryDate;
    private String surveyorSpecialization;
    private String surveyorRank;
    private EmployeeDto Employee;
    private StatusDto Status;
}