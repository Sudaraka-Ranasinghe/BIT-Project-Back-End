package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.DepartmentService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<StandardResponse> savedDepartment(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = departmentService.saveDepartment(data);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("{departmentId}")
    public ResponseEntity<StandardResponse> updateDepartment(@RequestBody RequestRegistryDto data, @PathVariable String departmentId){
        CommonResponseDto responseData = departmentService.updateDepartment(data,departmentId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("{departmentId}")
    public ResponseEntity<StandardResponse> deleteDepartment(@PathVariable String departmentId){
        CommonResponseDto responseData = departmentService.removeDepartment(departmentId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }


    @GetMapping
    public ResponseEntity<StandardResponse> getAllDepartment()throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Department List",
                        departmentService.allDepartment()),
                HttpStatus.OK
        );
    }
}
