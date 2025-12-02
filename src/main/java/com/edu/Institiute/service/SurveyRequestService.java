package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseSurveyRequestDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public interface SurveyRequestService {
    CommonResponseDto saveSurveyRequest(RequestRegistryDto dto);

    CommonResponseDto updateSurveyRequest(RequestRegistryDto dto, String surveyRequestId);

    PaginatedResponseSurveyRequestDto surveyRequestById(String surveyRequestCode) throws SQLException;

    CommonResponseDto removeSurveyRequest(String surveyRequestId);

    PaginatedResponseSurveyRequestDto allSurveyRequest() throws SQLException;
}
