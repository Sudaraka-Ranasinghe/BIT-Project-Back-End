package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.SurveyTeamDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.entity.SurveyProject;
import com.edu.Institiute.entity.Surveyor;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.*;
import com.edu.Institiute.service.SurveyTeamService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class SurveyTeamRegistryImpl implements SurveyTeamService {

    @Autowired
    private Generator generator;

    @Autowired
    private SurveyTeamRepo surveyTeamRepo;

    @Autowired
    private SurveyTeamMapper surveyTeamMapper;

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private SurveyorMapper surveyorMapper;

    @Autowired
    private SurveyorRepo surveyorRepo;

    @Autowired
    private SurveyProjectRepo surveyProjectRepo;

    @Autowired
    private SurveyProjectMapper surveyProjectMapper;

    // For save survey Team
    @Override
    public CommonResponseDto saveSurveyTeam(RequestRegistryDto dto) {
        Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
        // To Check if surveyorId already exists
        Optional<Surveyor> exxSurveyor = surveyorRepo.findByExxSurveyorId((dto.getSurveyorId()));
        // To check if surveyProjectId already exists
        Optional<SurveyProject> exxSurveyProject = surveyProjectRepo.findByExxSurveyProjectId((dto.getSurveyProjectId()));

        if (!exxSurveyProject.isEmpty() && !exxSurveyor.isEmpty()) {
            try {
                String surveyTeamId = generator.generateFourNumbers();
                SurveyTeamDto surveyTeamDto = new SurveyTeamDto(
                        surveyTeamId,
                        dto.getTeamRole(),
                        dto.getAssignedDate(),
                        dto.getReleasedDate(),
                        dto.getTeamCreatedBy(),
                        dto.getTeamCreatedDate(),
                        dto.getTeamModifiedBy(),
                        dto.getTeamModifiedDate(),
                        statusMapper.toStatusDto(status.get()),
                        surveyProjectMapper.toSurveyProjectrDto(exxSurveyProject.get()),
                        surveyorMapper.toSurveyorDto(exxSurveyor.get())
                );
                surveyTeamRepo.save(surveyTeamMapper.dtoToSurveyTeamEntity(surveyTeamDto));

                return new CommonResponseDto(201, "Survey Team  saved!", surveyTeamDto.getSurveyTeamId(), new ArrayList<>());
            } catch (Exception e) {
                throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
            }
        } else {
            throw new EntryNotFoundException("Can't Save because of this Surveyor or Survye Project not exists ");
        }
    }
}