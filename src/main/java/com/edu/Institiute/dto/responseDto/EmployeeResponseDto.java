package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import com.edu.Institiute.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {
    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeNICNumber;
    private String employeeOfficialEmail;
    private Date employeeDateOfBirth;
    private String employeeAddress;
    private String employeeContact;
    private Date employmentDate;
    private String employeeCreatedBy;
    private Date employeeCreatedDate;
    private String employeeModifiedBy;
    private Date employeeModifiedDate;
    private StatusDto Status;
}
