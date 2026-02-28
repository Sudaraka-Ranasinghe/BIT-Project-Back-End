package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.StatusDto;
import com.edu.Institiute.dto.SurveyInstrumentDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.repo.SurveyInstrumentRepo;
import com.edu.Institiute.service.SurveyInstrumentService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.StatusMapper;
import com.edu.Institiute.utill.mapper.SurveyInstrumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;


@Service
@Transactional
public class SurveyInstrumentRegistryImpl implements SurveyInstrumentService {

    @Autowired
    private Generator generator;

    @Autowired
    private SurveyInstrumentRepo  surveyInstrumentRepo;

    @Autowired
    private SurveyInstrumentMapper surveyInstrumentMapper;

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private StatusMapper statusMapper;

    // For save survey Instrument
    @Override
    public CommonResponseDto saveSurveyInstrument(RequestRegistryDto dto){
        Optional<Status> status = statusRepo.findById(dto.getStatus());

        String surveyInstrumentId = generator.generateFourNumbers();
        SurveyInstrumentDto surveyInstrumentDto = new SurveyInstrumentDto(
                surveyInstrumentId,
                dto.getInstrumentName(),
                dto.getSerialNumber(),
                dto.getInstrumentType(),
                dto.getCalibrationDate(),
                dto.getNextCalibrationDue(),
                dto.getInstrumentCreatedBy(),
                dto.getInstrumentCreatedDate(),
                dto.getInstrumentModifiedBy(),
                dto.getInstrumentModifiedDate(),
                statusMapper.toStatusDto(status.get())
        );
        surveyInstrumentRepo.save(surveyInstrumentMapper.dtoToSurveyInstrumentEntity(surveyInstrumentDto));
        return new CommonResponseDto(201, "Survey Instrument  saved!", surveyInstrumentDto.getSurveyInstrumentId(), new ArrayList<>());
    }

}
