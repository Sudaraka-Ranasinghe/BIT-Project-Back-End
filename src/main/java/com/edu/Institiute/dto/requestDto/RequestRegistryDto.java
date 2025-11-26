package com.edu.Institiute.dto.requestDto;

import com.edu.Institiute.dto.StatusDto;
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
    private String clientFullName;
    private String clientNic;
    private String clientAddress;
    private String clientEmail;
    private Number clientContact;
    private String clientCreatedBy;
    private Date clientCreatedDate;
    private String clientModifyBy;
    private Date clientModifyDate;

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

}
