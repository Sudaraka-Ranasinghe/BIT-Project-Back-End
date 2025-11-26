package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private String departmentId;
    private String departmentName;
    private String departmentCreatedBy;
    private Date departmentCreatedDate;
    private String departmentModifiedBy;
    private Date departmentModifiedDate;
    private StatusDto status;
}
