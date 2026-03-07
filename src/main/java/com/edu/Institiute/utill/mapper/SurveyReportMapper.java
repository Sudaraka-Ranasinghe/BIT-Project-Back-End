package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.SurveyReportDto;
import com.edu.Institiute.entity.SurveyReport;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface SurveyReportMapper {
    SurveyReport dtoToSurveyReportEntity(SurveyReportDto surveyReportDto);
    SurveyReportDto toSurveyReportDto(SurveyReport surveyReport);
}
