package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.SurveyPointDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.SurveyProject;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.SurveyPointRepo;
import com.edu.Institiute.repo.SurveyProjectRepo;
import com.edu.Institiute.service.SurveyPointService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.SurveyPointMapper;
import com.edu.Institiute.utill.mapper.SurveyProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class SurveyPointRegistryImpl implements SurveyPointService {

    @Autowired
    private Generator generator;

    @Autowired
    private SurveyPointRepo surveyPointRepo;

    @Autowired
    private SurveyPointMapper surveyPointMapper;

    @Autowired
    private SurveyProjectRepo surveyProjectRepo;

    @Autowired
    private SurveyProjectMapper surveyProjectMapper;

    @Override
    public CommonResponseDto saveSurveyPoint(RequestRegistryDto dto){
        // To find if projectId already exist
        Optional<SurveyProject> exxProject = surveyProjectRepo.findByExxSurveyProjectId(dto.getProjectId());

        if(!exxProject.isEmpty()){
            try{
                String surveyPointId = generator.generateFourNumbers();
                SurveyPointDto surveyPointDto = new SurveyPointDto(
                        surveyPointId,
                        dto.getNorth(),
                        dto.getEast(),
                        dto.getElevation(),
                        dto.getPointDescription(),
                        dto.getPointType(),
                        dto.getPointCreatedBy(),
                        dto.getPointCreatedDate(),
                        dto.getPointModifiedBy(),
                        dto.getPointModifiedDate(),
                        surveyProjectMapper.toSurveyProjectDto(exxProject.get())
                );
                surveyPointRepo.save(surveyPointMapper.dtoToSurveyPointEntity(surveyPointDto));
                return new CommonResponseDto(201, "Survey point  saved!", surveyPointDto.getSurveyPointId(), new ArrayList<>());
            } catch(Exception e){
                throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
            }
        }else {
            throw new EntryNotFoundException("Can't Save because of this survey Poject not exists ");
        }
    }
}
