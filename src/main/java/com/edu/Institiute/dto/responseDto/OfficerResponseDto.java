package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficerResponseDto {

    private String officerId;
    private String officerFullName;
    private String officerType;
    private String officerCreatedBy;
    private Date officerCreatedDate;
    private String officerModifyBy;
    private Date officerModifiedDate;
    private StatusDto status;
}
