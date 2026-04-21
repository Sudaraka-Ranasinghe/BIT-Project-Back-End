package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import com.edu.Institiute.dto.SurveyProjectDto;
import com.edu.Institiute.dto.SurveyorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyTeamResponseDto {
    private String surveyTeamId;
    private String teamRole;
    private Date assignedDate;
    private Date releasedDate;
    private String teamCreatedBy;
    private Date teamCreatedDate;
    private String teamModifiedBy;
    private Date teamModifiedDate;
    private StatusDto status;
    private SurveyProjectDto projectId;
    private SurveyorDto surveyorId;
}
