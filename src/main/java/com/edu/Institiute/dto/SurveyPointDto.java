package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyPointDto {

    private String surveyPointId;
    private Float north;
    private Float east;
    private Float elevation;
    private String pointDescription;
    private String pointType;
    private String pointCreatedBy;
    private Date pointCreatedDate;
    private String pointModifiedBy;
    private Date pointModifiedDate;
    private SurveyProjectDto SurveyProject;
}
