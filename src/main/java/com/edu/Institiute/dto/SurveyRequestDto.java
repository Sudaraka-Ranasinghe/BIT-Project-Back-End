package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRequestDto {

    private String surveyRequestId;
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
    private StatusDto Status;
    private ClientDto client;
}
