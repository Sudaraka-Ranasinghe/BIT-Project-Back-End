//package com.edu.Institiute.service.impl;
//
//import com.edu.Institiute.dto.SurveyRequestDto;
//import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
//import com.edu.Institiute.dto.responseDto.CommonResponseDto;
//import com.edu.Institiute.dto.responseDto.SurveyRequestResponseDto;
//import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseSurveyRequestDto;
//import com.edu.Institiute.entity.Status;
//import com.edu.Institiute.entity.SurveyRequest;
//import com.edu.Institiute.exception.EntryNotFoundException;
//import com.edu.Institiute.repo.StatusRepo;
//import com.edu.Institiute.repo.SurveyRequestRepo;
//import com.edu.Institiute.service.SurveyRequestService;
//import com.edu.Institiute.utill.Generator;
//import com.edu.Institiute.utill.mapper.StatusMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//@Service
//@Transactional
//public class SurveyRequestRegistryImpl implements SurveyRequestService {
//
//    @Autowired
//    private StatusRepo statusRepo;
//
//    @Autowired
//    private Generator generator;
//
//    @Autowired
//    private SurveyRequestMapper surveyRequestMapper;
//
//    @Autowired
//    private SurveyRequestRepo surveyRequestRepo;
//
//    @Autowired
//    private StatusMapper statusMapper;
//
//    @Override
//    public CommonResponseDto saveSurveyRequest(RequestRegistryDto dto) {
//        Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
//        try {
//
//            String surveyRequestId =  generator.generateFourNumbers();
//            SurveyRequestDto surveyRequestDto = new SurveyRequestDto(
//                    surveyRequestId,
//                    dto.getRequestDescription(),
//                    dto.getRequestDate(),
//                    dto.getPreferredDueDate(),
//                    dto.getLocationDescription(),
//                    dto.getPurposeOfSurvey(),
//                    dto.getAssignedAdminID(),
//                    dto.getRequestCreatedBy(),
//                    dto.getRequestCreatedDate(),
//                    dto.getRequestModifiedBy(),
//                    dto.getRequestModifiedDate(),
//                    dto.getClientId(),
//                    statusMapper.toStatusDto(status.get())
//            );
//            surveyRequestRepo.save(surveyRequestMapper.dtoToSurveyRequestEntity(surveyRequestDto));
//
//            return new CommonResponseDto(201, "SurveyRequest  saved!", surveyRequestDto.getRequestDescription(), new ArrayList<>());
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
//        }
//    }
//
//    @Override
//    public CommonResponseDto updateSurveyRequest(RequestRegistryDto dto, String surveyRequestId) {
//        try {
//            SurveyRequest allSurveyRequests = surveyRequestRepo.findBySurveyRequestId(surveyRequestId);
//            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
//
//            allSurveyRequests.setRequestDescription(dto.getRequestDescription());
//            allSurveyRequests.setRequestDate(dto.getRequestDate());
//            allSurveyRequests.setPreferredDueDate(dto.getPreferredDueDate());
//            allSurveyRequests.setLocationDescription(dto.getLocationDescription());
//            allSurveyRequests.setPurposeOfSurvey(dto.getPurposeOfSurvey());
//            allSurveyRequests.setAssignedAdminID(dto.getAssignedAdminID());
//            allSurveyRequests.setRequestCreatedBy(dto.getRequestCreatedBy());
//            allSurveyRequests.setRequestCreatedDate(dto.getRequestCreatedDate());
//            allSurveyRequests.setRequestModifiedBy(dto.getRequestModifiedBy());
//            allSurveyRequests.setRequestModifiedDate(dto.getRequestModifiedDate());
//            allSurveyRequests.setStatus(status.get());
//            SurveyRequestRepo.save(allSurveyRequests);
//
//            return new CommonResponseDto(201, "SurveyRequest  Updated!", allSurveyRequests.getRequestDescription(), new ArrayList<>());
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
//        }
//    }
//
//    @Override
//    public PaginatedResponseSurveyRequestDto surveyRequestById(String surveyRequestCode) throws SQLException {
//        try {
//            List<SurveyRequest> allSurveyRequestForProvidedId = surveyRequestRepo.getAllSurveyRequestForProvidedId(surveyRequestCode);
//            List<SurveyRequestResponseDto> surveyRequestResponseDos = new ArrayList<>();
//
//            for (SurveyRequest r : allSurveyRequestForProvidedId) {
//                surveyRequestResponseDos.add(
//                        new SurveyRequestResponseDto(
//
//                                r.getSurveyRequestId(),
//                                r.getRequestDescription(),
//                                r.getRequestDate(),
//                                r.getPreferredDueDate(),
//                                r.getLocationDescription(),
//                                r.getPurposeOfSurvey(),
//                                r.getAssignedAdminID(),
//                                r.getRequestCreatedBy(),
//                                r.getRequestCreatedDate(),
//                                r.getRequestModifiedBy(),
//                                r.getRequestModifiedDate(),
//                                r.getgetClientId(),
//                                statusMapper.toStatusDto(r.getStatus())
//                        )
//                );
//            }
//
//            return new PaginatedResponseSurveyRequestDto(
//                    surveyRequestRepo.count(),
//                    surveyRequestResponseDos
//            );
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't find any data for provided ID...!");
//        }
//
//    }
//
//    @Override
//    public CommonResponseDto removeSurveyRequest(String surveyRequestId) {
//
//        Optional<SurveyRequest> surveyRequest = surveyRequestRepo.getSurveyRequestsById(surveyRequestId);
//
//        if (surveyRequest.isPresent()) {
//            surveyRequestRepo.delete(surveyRequest.get());
//            return new CommonResponseDto(201, "SurveyRequest was deleted! ", true, new ArrayList<>());
//        } else {
//            throw new EntryNotFoundException("Can't find any SurveyRequest---...!");
//        }
//    }
//
//    @Override
//    public PaginatedResponseSurveyRequestDto allSurveyRequest() {
//        try {
//            List<SurveyRequest> allSurveyRequestForProvidedId = surveyRequestRepo.findAll();
//            List<SurveyRequestResponseDto> surveyRequestResponseDos = new ArrayList<>();
//
//            for (SurveyRequest r : allSurveyRequestForProvidedId) {
//                surveyRequestResponseDos.add(
//                        new SurveyRequestResponseDto(
//                                r.getSurveyRequestId(),
//                                r.getRequestDescription(),
//                                r.getRequestDate(),
//                                r.getPreferredDueDate(),
//                                r.getLocationDescription(),
//                                r.getPurposeOfSurvey(),
//                                r.getAssignedAdminID(),
//                                r.getRequestCreatedBy(),
//                                r.getRequestCreatedDate(),
//                                r.getRequestModifiedBy(),
//                                r.getRequestModifiedDate(),
//                                r.getgetClientId(),
//                                statusMapper.toStatusDto(r.getStatus())
//                        )
//                );
//            }
//
//            return new PaginatedResponseSurveyRequestDto(
//                    surveyRequestRepo.count(),
//                    surveyRequestResponseDos
//            );
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't find any data...!");
//        }
//    }
//}
