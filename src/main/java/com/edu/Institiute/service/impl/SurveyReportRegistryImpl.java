package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.SurveyReportDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.entity.SurveyProject;
import com.edu.Institiute.entity.Surveyor;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.repo.SurveyProjectRepo;
import com.edu.Institiute.repo.SurveyReportRepo;
import com.edu.Institiute.repo.SurveyorRepo;
import com.edu.Institiute.service.SurveyReportService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.StatusMapper;
import com.edu.Institiute.utill.mapper.SurveyProjectMapper;
import com.edu.Institiute.utill.mapper.SurveyReportMapper;
import com.edu.Institiute.utill.mapper.SurveyorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class SurveyReportRegistryImpl implements SurveyReportService {

    @Autowired
    private Generator generator;

    @Autowired
    private SurveyReportRepo surveyReportRepo;

    @Autowired
    private SurveyReportMapper surveyReportMapper;

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private SurveyProjectRepo surveyProjectRepo;

    @Autowired
    private SurveyProjectMapper surveyProjectMapper;

    @Autowired
    private SurveyorRepo surveyorRepo;

    @Autowired
    private SurveyorMapper surveyorMapper;

    // For save survey Report
    @Override
    public CommonResponseDto saveSurveyReport(RequestRegistryDto dto){
        Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
        // To check if survey project already exist
        Optional<SurveyProject> exxSurveyProject = surveyProjectRepo.findByExxSurveyProjectId(dto.getProjectId());
        // To check if surveyor already exist
        Optional<Surveyor> exxSurveyor = surveyorRepo.findByExxSurveyorId(dto.getSurveyorId());

        if(exxSurveyProject.isEmpty() && exxSurveyor.isEmpty()){
            try {
                String reportId = generator.generateFourNumbers();
                SurveyReportDto surveyReportDto = new SurveyReportDto(
                        reportId,
                        dto.getReportTitle(),
                        dto.getReportData(),
                        dto.getSummary(),
                        dto.getGeneratedDate(),
                        dto.getApprovalDate(),
                        dto.getReportCreatedBy(),
                        dto.getReportCreatedDate(),
                        dto.getReportModifiedBy(),
                        dto.getReportModifiedDate(),
                        statusMapper.toStatusDto(status.get()),
                        surveyProjectMapper.toSurveyProjectDto(exxSurveyProject.get()),
                        surveyorMapper.toSurveyorDto(exxSurveyor.get())
                );
                surveyReportRepo.save(surveyReportMapper.dtoToSurveyReportEntity(surveyReportDto));
                return new CommonResponseDto(201, "survey Report saved",surveyReportDto.getReportId(),new ArrayList<>());
            }  catch (Exception e){
                throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
            }
        }   else {
            throw new EntryNotFoundException("Can't Save because of survey project or surveyor not exists ");
        }
    }


}
