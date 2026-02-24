package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.SurveyProjectDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.entity.SurveyRequest;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.*;
import com.edu.Institiute.service.SurveyProjectService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;
@Service
@Transactional
public class SurveyProjectRegistryImpl implements SurveyProjectService {

    @Autowired
    private Generator generator;

    @Autowired
    private SurveyProjectMapper surveyProjectMapper;

    @Autowired
    private SurveyProjectRepo surveyProjectRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private SurveyRequestMapper surveyRequestMapper;

    @Autowired
    private SurveyRequestRepo SurveyRequestRepo;

    @Override
    public CommonResponseDto saveSurveyProject(RequestRegistryDto dto) {
        Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
        // To Check if SurveyRequestId already exists
        Optional<SurveyRequest> ExxSurveyRequest = SurveyRequestRepo.findByExxSurveyRequestId(dto.getSurveyRequestId());
        if (!ExxSurveyRequest.isEmpty()) {
            try {

                String surveyProjectId = generator.generateFourNumbers();
                SurveyProjectDto surveyProjectDto = new SurveyProjectDto(
                        surveyProjectId,
                        dto.getProjectTitle(),
                        dto.getProjectDescription(),
                        dto.getOfficialStartDate(),
                        dto.getEstimatedEndDate(),
                        dto.getActualEndDate(),
                        dto.getProjectLocation(),
                        dto.getProjectValue(),
                        dto.getProjectCreatedBy(),
                        dto.getProjectCreatedDate(),
                        dto.getProjectModifiedBy(),
                        dto.getProjectModifiedDate(),
                        statusMapper.toStatusDto(status.get()),
                        surveyRequestMapper.toSurveyRequestDto(ExxSurveyRequest.get())
                );
                surveyProjectRepo.save(surveyProjectMapper.dtoToSurveyProjectEntity(surveyProjectDto));

                return new CommonResponseDto(201, "Survey Project  saved!", surveyProjectDto.getProjectTitle(), new ArrayList<>());
            } catch (Exception e) {
                throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
            }
        } else {
            throw new EntryNotFoundException("Can't Save because of this Survey Request not exists ");
        }

    }
}
