package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyInstrumentResponseDto {
    private String surveyInstrumentId;
    private String instrumentName;
    private String serialNumber;
    private String instrumentType;
    private Date calibrationDate;
    private String nextCalibrationDue;
    private String instrumentCreatedBy;
    private Date instrumentCreatedDate;
    private String instrumentModifiedBy;
    private Date instrumentModifiedDate;
    private StatusDto status;
}
