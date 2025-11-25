package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDto {

    private String departmentId;
    private String departmentName;
    private String departmentCreatedBy;
    private Date departmentCreatedDate;
    private String departmentModifyBy;
    private Date departmentModifyDate;
    private StatusDto status;
}
