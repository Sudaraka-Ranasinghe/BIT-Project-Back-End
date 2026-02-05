package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.EmployeeDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.EmployeeResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseEmployeeDto;
import com.edu.Institiute.entity.Employee;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.*;
import com.edu.Institiute.service.EmployeeService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.EmployeeMapper;
import com.edu.Institiute.utill.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeRegistryImpl implements EmployeeService {

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private Generator generator;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public CommonResponseDto saveEmployee(RequestRegistryDto dto) {
        // To Check if NIC already exists
        Optional<Employee> nicExx = employeeRepo.getEmployeesByNIC(dto.getEmployeeNICNumber());
        System.out.println("nicExx : " +nicExx);
        if(nicExx.isEmpty()) {
            try {
                String employeeId = generator.generateFourNumbers();
                Optional<Status> status = statusRepo.findStatusById(dto.getStatus());

                EmployeeDto employeeDto = new EmployeeDto(
                        employeeId,
                        dto.getEmployeeFirstName(),
                        dto.getEmployeeLastName(),
                        dto.getEmployeeNICNumber(),
                        dto.getEmployeeOfficialEmail(),
                        dto.getEmployeeDateOfBirth(),
                        dto.getEmployeeAddress(),
                        dto.getEmployeeContact(),
                        dto.getEmploymentDate(),
                        dto.getEmployeeCreatedBy(),
                        new Date(),
                        "",
                        dto.getEmployeeModifiedDate(),
                        statusMapper.toStatusDto(status.get())
                );
                employeeRepo.save(employeeMapper.dtoToEmployeeEntity(employeeDto));

                return new CommonResponseDto(201, "Employee  saved!", employeeDto.getEmployeeFirstName(), new ArrayList<>());
            }catch(Exception e){
                throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }

        }
        else {
            throw new EntryNotFoundException("Can't Save because of this Employee already exists " );

        }

    }

    @Override
    public CommonResponseDto updateEmployee(RequestRegistryDto dto, String employeeId) {
        try {
            Employee allEmployees = employeeRepo.findByEmployeeId(employeeId);
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
            allEmployees.setEmployeeFirstName(dto.getEmployeeFirstName());
            allEmployees.setEmployeeLastName(dto.getEmployeeLastName());
            allEmployees.setEmployeeNICNumber( dto.getEmployeeNICNumber());
            allEmployees.setEmployeeOfficialEmail(dto.getEmployeeOfficialEmail());
            allEmployees.setEmployeeDateOfBirth( dto.getEmployeeDateOfBirth());
            allEmployees.setEmployeeAddress(dto.getEmployeeAddress());
            allEmployees.setEmployeeContact(dto.getEmployeeContact());
            allEmployees.setEmploymentDate(dto.getEmploymentDate());
            allEmployees.setEmployeeCreatedBy(dto.getEmployeeCreatedBy());
            allEmployees.setEmployeeCreatedDate(dto.getEmployeeCreatedDate());
            allEmployees.setEmployeeModifiedBy(dto.getEmployeeModifiedBy());
            allEmployees.setEmployeeModifiedDate(dto.getEmployeeModifiedDate());
            employeeRepo.save(allEmployees);
            return new CommonResponseDto(201, "Employee Updated!", allEmployees.getEmployeeFirstName(), new
                    ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error --> " + e);
        }
    }

    @Override
    public PaginatedResponseEmployeeDto employeeById(String employeeCode) throws SQLException {
        try {
            List<Employee> allEmployeeForProvidedId = employeeRepo.getAllEmployeeForProvidedId(employeeCode);
            List<EmployeeResponseDto> employeeResponseDos = new ArrayList<>();
            for (Employee r : allEmployeeForProvidedId) {
                employeeResponseDos.add(
                        new EmployeeResponseDto(
                                r.getEmployeeId(),
                                r.getEmployeeFirstName(),
                                r.getEmployeeLastName(),
                                r.getEmployeeNICNumber(),
                                r.getEmployeeOfficialEmail(),
                                r.getEmployeeDateOfBirth(),
                                r.getEmployeeAddress(),
                                r.getEmployeeContact(),
                                r.getEmploymentDate(),
                                r.getEmployeeCreatedBy(),
                                r.getEmployeeCreatedDate(),
                                r.getEmployeeModifiedBy(),
                                r.getEmployeeModifiedDate(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }
            return new PaginatedResponseEmployeeDto(
                    employeeRepo.count(),
                    employeeResponseDos
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }
    }
    @Override
    public CommonResponseDto removeEmployee(String employeeId) {
        Optional<Employee> employee = employeeRepo.getEmployeesById(employeeId);
        if (employee.isPresent()) {
            employeeRepo.delete(employee.get());
            return new CommonResponseDto(201, "Employee was deleted! ", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Employee---...!");
        }
    }
    @Override
    public PaginatedResponseEmployeeDto allEmployee() {
        try {
            List<Employee> allEmployeeForProvidedId = employeeRepo.findAll();
            List<EmployeeResponseDto> employeeResponseDos = new ArrayList<>();
            for (Employee r : allEmployeeForProvidedId) {
                employeeResponseDos.add(
                        new EmployeeResponseDto(
                                r.getEmployeeId(),
                                r.getEmployeeFirstName(),
                                r.getEmployeeLastName(),
                                r.getEmployeeNICNumber(),
                                r.getEmployeeOfficialEmail(),
                                r.getEmployeeDateOfBirth(),
                                r.getEmployeeAddress(),
                                r.getEmployeeContact(),
                                r.getEmploymentDate(),
                                r.getEmployeeCreatedBy(),
                                r.getEmployeeCreatedDate(),
                                r.getEmployeeModifiedBy(),
                                r.getEmployeeModifiedDate(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }
            return new PaginatedResponseEmployeeDto(
                    employeeRepo.count(),
                    employeeResponseDos
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }



}
