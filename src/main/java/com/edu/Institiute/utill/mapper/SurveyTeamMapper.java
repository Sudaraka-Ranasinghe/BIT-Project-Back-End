package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.SurveyTeamDto;
import com.edu.Institiute.entity.SurveyTeam;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface SurveyTeamMapper {
    SurveyTeam dtoToSurveyTeamEntity(SurveyTeamDto surveyTeamDto);
    SurveyTeamDto toSurveyTeamDto(SurveyTeam surveyTeam);
}
