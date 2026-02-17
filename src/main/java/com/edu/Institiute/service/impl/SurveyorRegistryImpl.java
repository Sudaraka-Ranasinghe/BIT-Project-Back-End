package com.edu.Institiute.service.impl;


import com.edu.Institiute.dto.SurveyorDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.SurveyorResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseSurveyorDto;
import com.edu.Institiute.entity.Employee;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.entity.Surveyor;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.EmployeeRepo;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.repo.SurveyorRepo;
import com.edu.Institiute.service.SurveyorService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.EmployeeMapper;
import com.edu.Institiute.utill.mapper.StatusMapper;
import com.edu.Institiute.utill.mapper.SurveyorMapper;
import com.vladmihalcea.hibernate.type.basic.NullableCharacterType;
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

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepo employeeRepo;

    // For save surveyor
    @Override
    public CommonResponseDto saveSurveyor(RequestRegistryDto dto) {
        Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
        // To Check if employeeId already exists
        Optional<Employee> employeeExx = employeeRepo.findByExxEmployeeId((dto.getEmployeeId()));

        //  if (employeeExx.isEmpty()) {
        try {

            String surveyorId = generator.generateFourNumbers();
            SurveyorDto surveyorDto = new SurveyorDto(
                    surveyorId,
                    dto.getSurveyorLicenseNumber(),
                    dto.getSurveyorLicenseExpiryDate(),
                    dto.getSurveyorSpecialization(),
                    dto.getSurveyorRank(),
                    employeeMapper.toEmployeeDto(employeeExx.get()),
                    statusMapper.toStatusDto(status.get())
            );
            surveyorRepo.save(surveyorMapper.dtoToSurveyorEntity(surveyorDto));

            return new CommonResponseDto(201, "Surveyor  saved!", surveyorDto.getSurveyorLicenseNumber(), new ArrayList<>());
        } catch (Exception e) {
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
            // }
            //      } else {
            //    throw new EntryNotFoundException("Can't Save because of this Employee not exists ");

        }
    }

    // For update surveyor
    @Override
    public CommonResponseDto updateSurveyor(RequestRegistryDto dto, String surveyorId) {
        try {
            Surveyor allSurveyors = surveyorRepo.findBySurveyorId(surveyorId);
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());

            allSurveyors.setSurveyorLicenseNumber(dto.getSurveyorLicenseNumber());
            allSurveyors.setSurveyorLicenseExpiryDate(dto.getSurveyorLicenseExpiryDate());
            allSurveyors.setSurveyorSpecialization(dto.getSurveyorSpecialization());
            allSurveyors.setSurveyorRank(dto.getSurveyorRank());
            allSurveyors.setStatus(status.get());
            surveyorRepo.save(allSurveyors);

            return new CommonResponseDto(201, "Surveyor  Updated!", allSurveyors.getSurveyorLicenseNumber(), new ArrayList<>());
        } catch (Exception e) {
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }
          // For get surveyor one by one
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
                                employeeMapper.toEmployeeDto(r.getEmployee()),
                                statusMapper.toStatusDto(r.getStatus())

                        )
                );
            }
            return new PaginatedResponseSurveyorDto(
                    surveyorRepo.count(),
                    surveyorResponseDos
            );
        } catch (Exception e) {
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }

    }

        // Remove Suveyors
    @Override
    public CommonResponseDto removeSurveyor(String surveyorId) {

        Optional<Surveyor> surveyor = surveyorRepo.getSurveyorById(surveyorId);

        if (surveyor.isPresent()) {
            surveyorRepo.delete(surveyor.get());
            return new CommonResponseDto(201, "Surveyor was deleted! ", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Surveyor---...!");
        }
    }    }
//        // For get all surveyors list
//    @Override
//    public PaginatedResponseSurveyorDto allSurveyor() {
//        try {
//            List<Surveyor> allSurveyorForProvidedId = surveyorRepo.findAll();
//            List<SurveyorResponseDto> surveyorResponseDos = new ArrayList<>();
//
//            for (Surveyor r : allSurveyorForProvidedId) {
//                surveyorResponseDos.add(
//                        new SurveyorResponseDto(
//                                r.getSurveyorId(),
//                                r.getSurveyorLicenseNumber(),
//                                r.getSurveyorLicenseExpiryDate(),
//                                r.getSurveyorSpecialization(),
//                                r.getSurveyorRank(),
//                                employeeMapper.toEmployeeDto(r.getEmployee()),
//                                statusMapper.toStatusDto(r.getStatus())
//                        )
//                );
//            }
//
//            return new PaginatedResponseSurveyorDto(
//                    surveyorRepo.count(),
//                    surveyorResponseDos
//            );
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't find any data...!");
//        }
//    }
//}
