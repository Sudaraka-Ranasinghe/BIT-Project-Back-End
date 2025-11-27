package com.edu.Institiute.api;


import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.EmployeeService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    public ResponseEntity<StandardResponse> savedEmployee(@RequestBody RequestRegistryDto data){
        CommonResponseDto commonResponseDto = employeeService.saveEmployee(data);
        return new ResponseEntity<>(
                new StandardResponse(
                        commonResponseDto.getCode(),
                        commonResponseDto.getMessage(),
                        commonResponseDto.getData()
                ),
                HttpStatus.CREATED
        );
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("{employeeId}")
    public ResponseEntity<StandardResponse> updateEmployee(@RequestBody RequestRegistryDto data, @PathVariable String employeeId){
        CommonResponseDto responseData = employeeService.updateEmployee(data,employeeId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("{employeeId}")
    public ResponseEntity<StandardResponse> getEmployee(@PathVariable String employeeId)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Employee List",
                        employeeService.employeeById(employeeId)),
                HttpStatus.OK
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("{employeeId}")
    public ResponseEntity<StandardResponse> deleteEmployee(@PathVariable String employeeId){
        CommonResponseDto responseData = employeeService.removeEmployee(employeeId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public ResponseEntity<StandardResponse> getAllEmployees()throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Employee List",
                        employeeService.allEmployee()),
                HttpStatus.OK
        );
    }
}
