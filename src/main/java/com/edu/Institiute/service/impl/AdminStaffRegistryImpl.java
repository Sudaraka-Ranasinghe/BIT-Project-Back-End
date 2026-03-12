package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.AdminStaffDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.Employee;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.AdminStaffRepo;
import com.edu.Institiute.repo.EmployeeRepo;
import com.edu.Institiute.service.AdminStaffService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.AdminStaffMapper;
import com.edu.Institiute.utill.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class AdminStaffRegistryImpl implements AdminStaffService {

    @Autowired
    private Generator generator;

    @Autowired
    private AdminStaffRepo adminStaffRepo;

    @Autowired
    private AdminStaffMapper adminStaffMapper;

    @Autowired
    private EmployeeRepo employeeRepo;

    // save Admin Staff
    @Autowired
    private EmployeeMapper employeeMapper;

    public CommonResponseDto saveAdminStaff(RequestRegistryDto dto) {
        // To find if Employee already exist
        Optional<Employee> exxEmployee = employeeRepo.findById(dto.getEmployeeId());
        if (!exxEmployee.isEmpty()) {
            try {
                String adminStaffId = generator.generateFourNumbers();
                AdminStaffDto adminStaffDto = new AdminStaffDto(
                        adminStaffId,
                        dto.getRole(),
                        employeeMapper.toEmployeeDto(exxEmployee.get())
                );
                adminStaffRepo.save(adminStaffMapper.dtoToAdminStaffEntity(adminStaffDto));
                return new CommonResponseDto(201,"Admin Staff saved",adminStaffDto.getAdminStaffId(), new ArrayList<>());
            }   catch (Exception e) {
                throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
            }
        } else {
            throw new EntryNotFoundException("Can't Save because of this Employee not exists ");
        }
    }


}
