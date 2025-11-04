package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.ClientDto;
import com.edu.Institiute.dto.CourseDto;
import com.edu.Institiute.dto.StatusDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.ClientResponseDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.StudentResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseClientDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseStudentDto;
import com.edu.Institiute.entity.*;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.ClientRepo;
import com.edu.Institiute.repo.CourseRepo;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.service.ClientService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.ClientMapper;
import com.edu.Institiute.utill.mapper.CourseMapper;
import com.edu.Institiute.utill.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientRegistryImpl implements ClientService {

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private Generator generator;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public CommonResponseDto saveClient(RequestRegistryDto dto) {
        Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
        try {
            String clientId =  generator.generateFourNumbers();
            ClientDto clientDto = new ClientDto(
                    clientId,
                    dto.getClientFullName(),
                    dto.getClientNic(),
                    dto.getClientAddress(),
                    dto.getClientEmail(),
                    dto.getClientContact(),
                    dto.getClientCreatedBy(),
                    dto.getClientCreatedDate(),
                    dto.getClientModifyBy(),
                    dto.getClientModifyDate(),
                    statusMapper.toStatusDto(status.get())
            );
            clientRepo.save(clientMapper.dtoToClientEntity(clientDto));

            return new CommonResponseDto(201, "Client  saved!", clientDto.getClientFullName(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }
    
    @Override
    public CommonResponseDto updateClient(RequestRegistryDto dto, String clientId) {
        try {
            Client allClients = clientRepo.findByClientId(clientId);
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());

            allClients.setClientFullName(dto.getClientFullName());
            allClients.setClientNic(dto.getClientNic());
            allClients.setClientAddress(dto.getClientAddress());
            allClients.setClientEmail(dto.getClientEmail());
            allClients.setClientContact(dto.getClientContact());
            allClients.setClientCreatedBy(dto.getClientCreatedBy());
            allClients.setClientCreatedDate(dto.getClientCreatedDate());
            allClients.setClientModifyBy(dto.getClientModifyBy());
            allClients.setClientModifyDate(dto.getClientModifyDate());
            allClients.setStatus(status.get());
            clientRepo.save(allClients);

            return new CommonResponseDto(201, "Client  Updated!", allClients.getClientFullName(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public PaginatedResponseClientDto clientById(String clientCode) throws SQLException {
        try {
            List<Client> allClientForProvidedId = clientRepo.getAllClientForProvidedId(clientCode);
            List<ClientResponseDto> clientResponseDos = new ArrayList<>();

            for (Client r : allClientForProvidedId) {
                clientResponseDos.add(
                        new ClientResponseDto(
                                r.getId(),
                                r.getClientFullName(),
                                r.getClientNic(),
                                r.getClientAddress(),
                                r.getClientEmail(),
                                r.getClientContact(),
                                r.getClientCreatedBy(),
                                r.getClientCreatedDate(),
                                r.getClientModifyBy(),
                                r.getClientModifyDate(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }

            return new PaginatedResponseClientDto(
                    clientRepo.count(),
                    clientResponseDos
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }

    }

}
