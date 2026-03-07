package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyReportDto {

    private String reportId;
    private String reportTitle;
    private String reportData;
    private String summary;
    private Date generatedDate;
    private Date approvalDate;
    private String reportCreatedBy;
    private Date reportCreatedDate;
    private String reportModifiedBy;
    private Date reportModifiedDate;
    private StatusDto Status;
    private SurveyProjectDto SurveyProject;
    private SurveyorDto Surveyor;

}
