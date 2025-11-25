package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficerDto {

    private String officerId;
    private String officerFullName;
    private String officerType;
    private String officerCreatedBy;
    private Date officerCreatedDate;
    private String officerModifyBy;
    private Date officerModifiedDate;
    private StatusDto status;
}
