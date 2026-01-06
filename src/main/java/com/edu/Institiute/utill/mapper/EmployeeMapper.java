package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.EmployeeDto;
import com.edu.Institiute.entity.Employee;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee dtoToEmployeeEntity(EmployeeDto employeeDto);
    EmployeeDto toEmployeeDto(Employee employee);
}
