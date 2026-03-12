package com.edu.Institiute.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
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
//    private String officerId;
//    private String officerFullName;
//    private String officerType;
//    private String officerCreatedBy;
//    private Date officerCreatedDate;
//    private String officerModifyBy;
//    private Date officerModifiedDate;

    // Department
//    private String departmentId;
//    private String departmentName;
//    private String departmentCreatedBy;
//    private Date departmentCreatedDate;
//    private String departmentModifiedBy;
//    private Date departmentModifiedDate;


    // Employee
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


    //Surveyor
    private String surveyorLicenseNumber;
    private Date surveyorLicenseExpiryDate;
    private String surveyorSpecialization;
    private String surveyorRank;
    private String employeeId;

     //SurveyRequest
    private String requestDescription;
    private Date requestDate;
    private Date preferredDueDate;
    private String locationDescription;
    private String purposeOfSurvey;
    private String assignedAdminId;
    private String requestCreatedBy;
    private Date requestCreatedDate;
    private String requestModifiedBy;
    private Date requestModifiedDate;
    private String ClientId;


    // Survey Project
    private String projectTitle;
    private String projectDescription;
    private Date officialStartDate;
    private Date estimatedEndDate;
    private Date actualEndDate;
    private String projectLocation;
    private String projectValue;
    private String projectCreatedBy;
    private Date projectCreatedDate;
    private String projectModifiedBy;
    private Date projectModifiedDate;
    private String SurveyRequestId;

    // Survey Team
    private String teamRole;
    private Date assignedDate;
    private Date releasedDate;
    private String teamCreatedBy;
    private Date teamCreatedDate;
    private String teamModifiedBy;
    private Date teamModifiedDate;
    private String projectId;
    private String SurveyorId;

    // Survey Instrument
    private String instrumentName;
    private String serialNumber;
    private String instrumentType;
    private Date calibrationDate;
    private String nextCalibrationDue;
    private String instrumentCreatedBy;
    private Date instrumentCreatedDate;
    private String instrumentModifiedBy;
    private Date instrumentModifiedDate;

    // Survey Point
    private Float north;
    private Float east;
    private Float elevation;
    private String pointDescription;
    private String pointType;
    private String pointCreatedBy;
    private Date pointCreatedDate;
    private String pointModifiedBy;
    private Date pointModifiedDate;
   // private String ProjectId;

    // Survey Report
    private String reportTitle;
    private String reportData;
    private String summary;
    private Date generatedDate;
    private Date approvalDate;
    private String reportCreatedBy;
    private Date reportCreatedDate;
    private String reportModifiedBy;
    private Date reportModifiedDate;
    private String surveyorId;

    // Land Parcel
    private String titleDeedNumber;
    private String area;
    private String address;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    // Invoice
    private Date issueDate;
    private Date dueDate;
    private Float amount;
    private Float taxAmount;
    private Float totalAmount;
    private String invoiceCreatedBy;
    private Date invoiceCreatedDate;
    private String invoiceModifiedBy;
    private Date invoiceModifiedDate;

    // Admin Staff
    private String role;
    private String EmployeeId;

    // Payment
    private Date paymentDate;
    private Float amountPaid;
    private String paymentMethod;
    private String transactionReference;
    private String receivedBy;
    private String paymentCreatedBy;
    private Date paymentCreatedDate;
    private String paymentModifiedBy;
    private Date paymentModifiedDate;
    private String InvoiceId;
    private String AdminStaffId;

}
