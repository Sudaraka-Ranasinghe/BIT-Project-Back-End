package com.edu.Institiute.utill.mapper;



import com.edu.Institiute.dto.SurveyProjectDto;
import com.edu.Institiute.entity.SurveyProject;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface SurveyProjectMapper {
    SurveyProject dtoToSurveyProjectEntity(SurveyProjectDto surveyProjectDto);
    SurveyProjectDto toSurveyProjectDto(SurveyProject surveyProject);
}
