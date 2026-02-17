package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.SurveyorService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/surveyor")
public class SurveyorController {
    @Autowired
    private SurveyorService surveyorService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    public ResponseEntity<StandardResponse> savedSurveyor(@RequestBody RequestRegistryDto data){
        CommonResponseDto commonResponseDto = surveyorService.saveSurveyor(data);
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
    @PutMapping("{surveyorId}")
    public ResponseEntity<StandardResponse> updateSurveyor(@RequestBody RequestRegistryDto data, @PathVariable String surveyorId){
        CommonResponseDto responseData = surveyorService.updateSurveyor(data,surveyorId);
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
    @GetMapping("{surveyorId}")
    public ResponseEntity<StandardResponse> getSurveyor(@PathVariable String surveyorId)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Surveyor List",
                        surveyorService.surveyorById(surveyorId)),
                HttpStatus.OK
        );
    }

//    @CrossOrigin(origins = "http://localhost:4200/")
//    @DeleteMapping("{surveyorId}")
//    public ResponseEntity<StandardResponse> deleteSurveyor(@PathVariable String surveyorId){
//        CommonResponseDto responseData = surveyorService.removeSurveyor(surveyorId);
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
//    public ResponseEntity<StandardResponse> getAllSurveyors()throws SQLException{
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        200,
//                        "Surveyor List",
//                        surveyorService.allSurveyor()),
//                HttpStatus.OK
//        );
//    }
}
