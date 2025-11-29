package com.edu.Institiute.dto.requestDto;

import com.edu.Institiute.dto.StatusDto;
import com.edu.Institiute.entity.Client;
import com.edu.Institiute.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class RequestRegistryDto {

    private String studentCode;
    private String studentName;
    private String studentAge;
    private String studentNic;
    private Integer status;

    private String courseCode;
    private String courseName;

    // Client
    private String clientId;
    private String clientType;
    private String clientName;
    private String contactPersonName;
    private String clientPhoneNumbers;
    private String clientEmail;
    private String clientRegisteredAddress;
    private String clientBillingAddress;
    private String clientCreatedBy;
    private Date clientCreatedDate;
    private String clientModifiedBy;
    private Date clientModifiedDate;


    // Officer
    private String officerId;
    private String officerFullName;
    private String officerType;
    private String officerCreatedBy;
    private Date officerCreatedDate;
    private String officerModifyBy;
    private Date officerModifiedDate;

    // Department
    private String departmentId;
    private String departmentName;
    private String departmentCreatedBy;
    private Date departmentCreatedDate;
    private String departmentModifiedBy;
    private Date departmentModifiedDate;

    // Employee
    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeNICNumber;
    private String employeeOfficialEmail;
    private Date employeeDateOfBirth;
    private String employeeAddress;
    private Number employeeContact;
    private Date employmentDate;
    private String employeeCreatedBy;
    private Date employeeCreatedDate;
    private String employeeModifiedBy;
    private Date employeeModifiedDate;

    // Surveyor
    private String surveyorId;
    private String surveyorLicenseNumber;
    private Date surveyorLicenseExpiryDate;
    private String surveyorSpecialization;
    private String surveyorRank;
    private Employee Employee;

    // SurveyRequest
    private String surveyRequestId;
    private String requestDescription;
    private Date requestDate;
    private Date preferredDueDate;
    private String locationDescription;
    private String purposeOfSurvey;
    private String assignedAdminID;
    private String requestCreatedBy;
    private Date requestCreatedDate;
    private String requestModifiedBy;
    private Date requestModifiedDate;
    private StatusDto Status;
    private Client Client;

}
