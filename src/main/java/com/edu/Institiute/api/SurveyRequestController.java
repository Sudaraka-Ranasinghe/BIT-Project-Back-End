//package com.edu.Institiute.api;
//
//import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
//import com.edu.Institiute.dto.responseDto.CommonResponseDto;
//import com.edu.Institiute.service.SurveyRequestService;
//import com.edu.Institiute.utill.StandardResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.SQLException;
//
//@CrossOrigin(origins = "http://localhost:4200/")
//@RestController
//@RequestMapping("/api/v1/surveyRequest")
//public class SurveyRequestController {
//    @Autowired
//    private SurveyRequestService surveyRequestService;
//
//    @CrossOrigin(origins = "http://localhost:4200/")
//    @PostMapping
//    public ResponseEntity<StandardResponse> savedSurveyRequest(@RequestBody RequestRegistryDto data){
//        CommonResponseDto commonResponseDto = surveyRequestService.saveSurveyRequest(data);
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        commonResponseDto.getCode(),
//                        commonResponseDto.getMessage(),
//                        commonResponseDto.getData()
//                ),
//                HttpStatus.CREATED
//        );
//    }
//
//    @CrossOrigin(origins = "http://localhost:4200/")
//    @PutMapping("{surveyRequestId}")
//    public ResponseEntity<StandardResponse> updateSurveyRequest(@RequestBody RequestRegistryDto data, @PathVariable String surveyRequestId){
//        CommonResponseDto responseData = surveyRequestService.updateSurveyRequest(data,surveyRequestId);
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
//    @GetMapping("{surveyRequestId}")
//    public ResponseEntity<StandardResponse> getSurveyRequest(@PathVariable String surveyRequestId)throws SQLException {
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        200,
//                        "SurveyRequest List",
//                        surveyRequestService.surveyRequestById(surveyRequestId)),
//                HttpStatus.OK
//        );
//    }
//
//    @CrossOrigin(origins = "http://localhost:4200/")
//    @DeleteMapping("{surveyRequestId}")
//    public ResponseEntity<StandardResponse> deleteSurveyRequest(@PathVariable String surveyRequestId){
//        CommonResponseDto responseData = surveyRequestService.removeSurveyRequest(surveyRequestId);
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
//    public ResponseEntity<StandardResponse> getAllSurveyRequests()throws SQLException{
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        200,
//                        "SurveyRequest List",
//                        surveyRequestService.allSurveyRequest()),
//                HttpStatus.OK
//        );
//    }
//}
