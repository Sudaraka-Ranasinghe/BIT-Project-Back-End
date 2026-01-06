package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.OfficerService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/officer")
public class OfficerController  {

//    @Autowired
//    private OfficerService officerService;
//
//    @CrossOrigin(origins = "http://localhost:4200/")
//    @PostMapping
//    public ResponseEntity<StandardResponse> savedOfficer(@RequestBody RequestRegistryDto data){
//        CommonResponseDto commonResponseDto = officerService.saveOfficer(data);
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        commonResponseDto.getCode(),
//                        commonResponseDto.getMessage(),
//                        commonResponseDto.getData()
//                ),
//                HttpStatus.CREATED
//        );
//    }
//    @CrossOrigin(origins = "http://localhost:4200/")
//    @PutMapping("{officerId}")
//    public ResponseEntity<StandardResponse> updateOfficer(@RequestBody RequestRegistryDto data, @PathVariable String officerId){
//        CommonResponseDto responseData = officerService.updateOfficer(data,officerId);
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        responseData.getCode(),
//                        responseData.getMessage(),
//                        responseData.getData()
//                ),
//                HttpStatus.CREATED
//        );
//    }
//
//    @CrossOrigin(origins = "http://localhost:4200/")
//    @GetMapping("{officerId}")
//    public ResponseEntity<StandardResponse> getOfficer(@PathVariable String officerId)throws SQLException {
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        200,
//                        "Officer List",
//                        officerService.officerById(officerId)),
//                HttpStatus.OK
//        );
//    }
//
//    @CrossOrigin(origins = "http://localhost:4200/")
//    @DeleteMapping("{officerId}")
//    public ResponseEntity<StandardResponse> deleteOfficer(@PathVariable String officerId){
//        CommonResponseDto responseData = officerService.removeOfficer(officerId);
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        responseData.getCode(),
//                        responseData.getMessage(),
//                        responseData.getData()
//                ),
//                HttpStatus.CREATED
//        );
//    }
//
//    @CrossOrigin(origins = "http://localhost:4200/")
//    @GetMapping
//    public ResponseEntity<StandardResponse> getAllOfficers()throws SQLException{
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        200,
//                        "Officer List",
//                        officerService.allOfficer()),
//                HttpStatus.OK
//        );
//    }
}
