package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.SurveyRequestDto;
import com.edu.Institiute.entity.SurveyRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface SurveyRequestMapper {
    SurveyRequest dtoToSurveyRequestEntity(SurveyRequestDto surveyRequestrDto);
    SurveyRequestDto toSurveyRequestDto(SurveyRequest surveyRequest);
}
