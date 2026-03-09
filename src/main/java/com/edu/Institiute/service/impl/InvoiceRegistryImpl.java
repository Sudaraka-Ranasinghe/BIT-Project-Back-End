package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.*;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.Client;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.entity.SurveyProject;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.ClientRepo;
import com.edu.Institiute.repo.InvoiceRepo;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.repo.SurveyProjectRepo;
import com.edu.Institiute.service.InvoiceService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.ClientMapper;
import com.edu.Institiute.utill.mapper.InvoiceMapper;
import com.edu.Institiute.utill.mapper.StatusMapper;
import com.edu.Institiute.utill.mapper.SurveyProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class InvoiceRegistryImpl implements InvoiceService {

    @Autowired
    private Generator generator;

    @Autowired
    private InvoiceRepo  invoiceRepo;

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private SurveyProjectRepo surveyProjectRepo;

    @Autowired
    private SurveyProjectMapper surveyProjectMapper;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public CommonResponseDto saveInvoice(RequestRegistryDto dto){
        Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
        // To find if projectId already exist
        Optional<SurveyProject> exxProject = surveyProjectRepo.findByExxSurveyProjectId(dto.getProjectId());
        // To find if client already exist
        Optional<Client> exxClient = clientRepo.findByExxClientId(dto.getClientId());

        if(!exxProject.isEmpty() && !exxClient.isEmpty()){
            try{
                String invoiceId = generator.generateFourNumbers();
                InvoiceDto invoiceDto = new InvoiceDto(
                        invoiceId,
                        dto.getIssueDate(),
                        dto.getDueDate(),
                        dto.getAmount(),
                        dto.getTaxAmount(),
                        dto.getTotalAmount(),
                        dto.getInvoiceCreatedBy(),
                        dto.getInvoiceCreatedDate(),
                        dto.getInvoiceModifiedBy(),
                        dto.getInvoiceModifiedDate(),
                        statusMapper.toStatusDto(status.get()),
                        surveyProjectMapper.toSurveyProjectDto(exxProject.get()),
                        clientMapper.toClientDto(exxClient.get())
                );
                invoiceRepo.save(invoiceMapper.dtoToInvoiceEntity(invoiceDto));
                return new CommonResponseDto(201, "Invoice  saved!", invoiceDto.getInvoiceId(), new ArrayList<>());
            } catch(Exception e){
                throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
            }
        }else {
            throw new EntryNotFoundException("Can't Save because of this survey Project or this client not exists ");
        }
    }


}
