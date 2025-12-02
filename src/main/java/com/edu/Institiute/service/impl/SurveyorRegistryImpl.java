package com.edu.Institiute.service.impl;


import com.edu.Institiute.dto.SurveyorDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.SurveyorResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseSurveyorDto;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.entity.Surveyor;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.repo.SurveyorRepo;
import com.edu.Institiute.service.SurveyorService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SurveyorRegistryImpl implements SurveyorService {

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private Generator generator;

    @Autowired
    private SurveyorMapper surveyorMapper;

    @Autowired
    private SurveyorRepo surveyorRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public CommonResponseDto saveSurveyor(RequestRegistryDto dto) {
        Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
        try {

            String surveyorId =  generator.generateFourNumbers();
            SurveyorDto surveyorDto = new SurveyorDto(
                    surveyorId,
                    dto.getSurveyorLicenseNumber(),
                    dto.getSurveyorLicenseExpiryDate(),
                    dto.getSurveyorSpecialization(),
                    dto.getSurveyorRank(),
                    dto.getEmployeeId()
            );
            surveyorRepo.save(surveyorMapper.dtoToSurveyorEntity(surveyorDto));

            return new CommonResponseDto(201, "Surveyor  saved!", surveyorDto.getSurveyorLicenseNumber(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto updateSurveyor(RequestRegistryDto dto, String surveyorId) {
        try {
            Surveyor allSurveyors = surveyorRepo.findBySurveyorId(surveyorId);
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());

            allSurveyors.setSurveyorLicenseNumber(dto.getSurveyorLicenseNumber());
            allSurveyors.setSurveyorLicenseExpiryDate(dto.getSurveyorLicenseExpiryDate());
            allSurveyors.setSurveyorSpecialization(dto.getSurveyorSpecialization());
            allSurveyors.setSurveyorRank(dto.getSurveyorRank());
            surveyorRepo.save(allSurveyors);

            return new CommonResponseDto(201, "Surveyor  Updated!", allSurveyors.getSurveyorLicenseNumber(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public PaginatedResponseSurveyorDto surveyorById(String surveyorCode) throws SQLException {
        try {
            List<Surveyor> allSurveyorForProvidedId = surveyorRepo.getAllSurveyorForProvidedId(surveyorCode);
            List<SurveyorResponseDto> surveyorResponseDos = new ArrayList<>();

            for (Surveyor r : allSurveyorForProvidedId) {
                surveyorResponseDos.add(
                        new SurveyorResponseDto(
                                r.getSurveyorId(),
                                r.getSurveyorLicenseNumber(),
                                r.getSurveyorLicenseExpiryDate(),
                                r.getSurveyorSpecialization(),
                                r.getSurveyorRank(),
                                r.getEmployeeEmployeeId(),

                        )
                );
            }

            return new PaginatedResponseSurveyorDto(
                    surveyorRepo.count(),
                    surveyorResponseDos
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }

    }

    @Override
    public CommonResponseDto removeSurveyor(String surveyorId) {

        Optional<Surveyor> surveyor = surveyorRepo.getSurveyorsById(surveyorId);

        if (surveyor.isPresent()) {
            surveyorRepo.delete(surveyor.get());
            return new CommonResponseDto(201, "Surveyor was deleted! ", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Surveyor---...!");
        }
    }

    @Override
    public PaginatedResponseSurveyorDto allSurveyor() {
        try {
            List<Surveyor> allSurveyorForProvidedId = surveyorRepo.findAll();
            List<SurveyorResponseDto> surveyorResponseDos = new ArrayList<>();

            for (Surveyor r : allSurveyorForProvidedId) {
                surveyorResponseDos.add(
                        new SurveyorResponseDto(
                                r.getSurveyorId(),
                                r.getSurveyorLicenseNumber(),
                                r.getSurveyorLicenseExpiryDate(),
                                r.getSurveyorSpecialization(),
                                r.getSurveyorRank(),
                                r.getEmployeeEmployeeId(),
                        )
                );
            }

            return new PaginatedResponseSurveyorDto(
                    surveyorRepo.count(),
                    surveyorResponseDos
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }
}
