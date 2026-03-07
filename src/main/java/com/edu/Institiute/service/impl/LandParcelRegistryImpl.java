package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.LandParcelDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.entity.SurveyProject;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.LandParcelRepo;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.repo.SurveyProjectRepo;
import com.edu.Institiute.service.LandParcelService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.LandParcelMapper;
import com.edu.Institiute.utill.mapper.StatusMapper;
import com.edu.Institiute.utill.mapper.SurveyProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class LandParcelRegistryImpl implements LandParcelService {

    @Autowired
    private Generator generator;

    @Autowired
    private LandParcelRepo landParcelRepo;

    @Autowired
    private LandParcelMapper landParcelMapper;

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private SurveyProjectRepo surveyProjectRepo;

    @Autowired
    private SurveyProjectMapper surveyProjectMapper;

    // For save Land Parcel
    @Override
    public CommonResponseDto saveLandParcel (RequestRegistryDto dto){
        Optional<Status> status = statusRepo.findById(dto.getStatus());
        // To find if project already exist
        Optional<SurveyProject> exxProject = surveyProjectRepo.findByExxSurveyProjectId(dto.getProjectId());

        if(exxProject.isPresent()){
            try {
                String landParcelId = generator.generateFourNumbers();
                LandParcelDto landParcelDto = new LandParcelDto(
                        landParcelId,
                        dto.getTitleDeedNumber(),
                        dto.getArea(),
                        dto.getAddress(),
                        dto.getCreatedBy(),
                        dto.getCreatedDate(),
                        dto.getModifiedBy(),
                        dto.getModifiedDate(),
                        statusMapper.toStatusDto(status.get()),
                        surveyProjectMapper.toSurveyProjectDto(exxProject.get())
                );
                landParcelRepo.save(landParcelMapper.dtoToLandParcelEntity(landParcelDto));
                return new CommonResponseDto(201,"Land parcel saved!", landParcelDto.getLandParcelId(), new ArrayList<>());
            }   catch (Exception e) {
                throw new EntryNotFoundException(" Land parcel cannot be save because of this error" + e);
            }
        }   else {
            throw new EntryNotFoundException("Land parcel cannot be created because of survey project not exists");
        }

    }
}
