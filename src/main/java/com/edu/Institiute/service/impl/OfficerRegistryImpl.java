package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.OfficerDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.OfficerResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseOfficerDto;
import com.edu.Institiute.entity.Officer;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.*;
import com.edu.Institiute.service.OfficerService;
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
public class OfficerRegistryImpl implements OfficerService {

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private Generator generator;

    @Autowired
    private OfficerMapper officerMapper;

    @Autowired
    private OfficerRepo officerRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public CommonResponseDto saveOfficer(RequestRegistryDto dto) {
        Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
        try {
            String officerId =  generator.generateFourNumbers();
            OfficerDto officerDto = new OfficerDto(
                    officerId,
                    dto.getOfficerFullName(),
                    dto.getOfficerType(),
                    dto.getOfficerCreatedBy(),
                    dto.getOfficerCreatedDate(),
                    dto.getOfficerModifyBy(),
                    dto.getOfficerModifyDate(),
                    statusMapper.toStatusDto(status.get())
            );
            officerRepo.save(officerMapper.dtoToOfficerEntity(officerDto));

            return new CommonResponseDto(201, "Officer  saved!", officerDto.getOfficerFullName(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto updateOfficer(RequestRegistryDto dto, String officerId) {
        try {
            Officer allOfficers = officerRepo.findByOfficerId(officerId);
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());

            allOfficers.setOfficerFullName(dto.getOfficerFullName());
            allOfficers.setOfficerType(dto.getOfficerType());
            allOfficers.setOfficerCreatedBy(dto.getOfficerCreatedBy());
            allOfficers.setOfficerCreatedDate(dto.getOfficerCreatedDate());
            allOfficers.setOfficerModifyBy(dto.getOfficerModifyBy());
            allOfficers.setOfficerModifyDate(dto.getOfficerModifyDate());
            allOfficers.setStatus(status.get());
            officerRepo.save(allOfficers);

            return new CommonResponseDto(201, "Officer  Updated!", allOfficers.getOfficerFullName(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }
    @Override
    public PaginatedResponseOfficerDto officerById(String officerCode) throws SQLException {
        try {
            List<Officer> allOfficerForProvidedId = officerRepo.getAllOfficerForProvidedId(officerCode);
            List<OfficerResponseDto> officerResponseDos = new ArrayList<>();

            for (Officer r : allOfficerForProvidedId) {
                officerResponseDos.add(
                        new OfficerResponseDto(
                                r.getOfficerId(),
                                r.getOfficerFullName(),
                                r.getOfficerType(),
                                r.getOfficerCreatedBy(),
                                r.getOfficerCreatedDate(),
                                r.getOfficerModifyBy(),
                                r.getOfficerModifyDate(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }

            return new PaginatedResponseOfficerDto(
                    officerRepo.count(),
                    officerResponseDos
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }

    }

    @Override
    public CommonResponseDto removeOfficer(String officerId) {

        Optional<Officer> officer = officerRepo.getOfficersById(officerId);

        if (officer.isPresent()) {
            officerRepo.delete(officer.get());
            return new CommonResponseDto(201, "Officer was deleted! ", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Officer---...!");
        }
    }

    @Override
    public PaginatedResponseOfficerDto allOfficer() {
        try {
            List<Officer> allOfficerForProvidedId = officerRepo.findAll();
            List<OfficerResponseDto> officerResponseDos = new ArrayList<>();

            for (Officer r : allOfficerForProvidedId) {
                officerResponseDos.add(
                        new OfficerResponseDto(
                                r.getOfficerId(),
                                r.getOfficerFullName(),
                                r.getOfficerType(),
                                r.getOfficerCreatedBy(),
                                r.getOfficerCreatedDate(),
                                r.getOfficerModifyBy(),
                                r.getOfficerModifyDate(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }

            return new PaginatedResponseOfficerDto(
                    officerRepo.count(),
                    officerResponseDos
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }
}
