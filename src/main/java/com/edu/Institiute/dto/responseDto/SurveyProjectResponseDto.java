package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import com.edu.Institiute.dto.SurveyRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyProjectResponseDto {
    private String projectId;
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
    private StatusDto Status;
    private SurveyRequestDto SurveyRequestId;
}
