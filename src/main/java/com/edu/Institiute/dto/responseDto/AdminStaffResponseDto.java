package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminStaffResponseDto {

    private String adminStaffId;
    private String role;
    private EmployeeDto EmployeeId;
}
