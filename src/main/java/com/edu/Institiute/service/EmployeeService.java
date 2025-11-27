package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseClientDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseEmployeeDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public interface EmployeeService {
    CommonResponseDto saveEmployee(RequestRegistryDto dto);

    CommonResponseDto updateEmployee(RequestRegistryDto dto, String employeeId);

    PaginatedResponseEmployeeDto employeeById(String employeeCode) throws SQLException;

    CommonResponseDto removeEmployee(String employeeId);

    PaginatedResponseEmployeeDto allEmployee() throws SQLException;
}
