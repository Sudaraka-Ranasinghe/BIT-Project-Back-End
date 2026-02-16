package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseSurveyorDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public interface SurveyorService {

    CommonResponseDto saveSurveyor(RequestRegistryDto dto);

//    CommonResponseDto updateSurveyor(RequestRegistryDto dto, String surveyorId);
//
//    PaginatedResponseSurveyorDto surveyorById(String surveyorCode) throws SQLException;
//
//    CommonResponseDto removeSurveyor(String surveyorId);
//
//    PaginatedResponseSurveyorDto allSurveyor() throws SQLException;
}
