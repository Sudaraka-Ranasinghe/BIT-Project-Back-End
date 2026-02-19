package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.ClientDto;
import com.edu.Institiute.dto.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRequestResponseDto {
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
    private ClientDto ClientId;
}
