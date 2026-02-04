package com.edu.Institiute.dto;

import com.edu.Institiute.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
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
