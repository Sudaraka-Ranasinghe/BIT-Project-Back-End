package com.edu.Institiute.dto;

import com.edu.Institiute.entity.Client;
import com.edu.Institiute.entity.Status;
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
    private String assignedAdminID;
    private String requestCreatedBy;
    private Date requestCreatedDate;
    private String requestModifiedBy;
    private Date requestModifiedDate;
    private StatusDto Status;
    private Client Client;
}
