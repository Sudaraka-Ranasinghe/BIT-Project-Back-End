package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyTeamDto {

    private String surveyTeamId;
    private String teamRole;
    private Date assignedDate;
    private Date releasedDate;
    private String teamCreatedBy;
    private Date teamCreatedDate;
    private String teamModifiedBy;
    private Date teamModifiedDate;
    private StatusDto Status;
    private SurveyProjectDto SurveyProject;
    private SurveyorDto Surveyor;
}
