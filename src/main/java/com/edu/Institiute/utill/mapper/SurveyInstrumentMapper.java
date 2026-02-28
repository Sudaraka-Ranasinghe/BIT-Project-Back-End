package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.SurveyInstrumentDto;
import com.edu.Institiute.entity.SurveyInstrument;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface SurveyInstrumentMapper {
    SurveyInstrument dtoToSurveyInstrumentEntity(SurveyInstrumentDto surveyInstrumentDto);
    SurveyInstrumentDto toSurveyInstrumentDto(SurveyInstrument surveyInstrument);
}
