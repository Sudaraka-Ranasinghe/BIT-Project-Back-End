package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import org.springframework.stereotype.Service;


@Service
public interface SurveyProjectService {
    CommonResponseDto saveSurveyProject(RequestRegistryDto dto);
//
//    CommonResponseDto updateSurveyProject(RequestRegistryDto dto, String surveyorId);
//
//    PaginatedResponseSurveyorDto SurveyProjectById(String surveyorCode) throws SQLException;
//
//    CommonResponseDto removeSurveyProject(String surveyorId);
//
//    PaginatedResponseSurveyorDto allSurveyProject() throws SQLException;
}
