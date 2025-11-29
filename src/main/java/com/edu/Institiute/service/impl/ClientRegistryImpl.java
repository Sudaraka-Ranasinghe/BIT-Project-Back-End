package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.ClientDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.ClientResponseDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseClientDto;
import com.edu.Institiute.entity.*;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.ClientRepo;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.service.ClientService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.ClientMapper;
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
                    dto.getClientType(),
                    dto.getClientName(),
                    dto.getContactPersonName(),
                    dto.getClientPhoneNumbers(),
                    dto.getClientEmail(),
                    dto.getClientRegisteredAddress(),
                    dto.getClientBillingAddress(),
                    dto.getClientCreatedBy(),
                    dto.getClientCreatedDate(),
                    dto.getClientModifiedBy(),
                    dto.getClientModifiedDate(),
                    statusMapper.toStatusDto(status.get())
            );
            clientRepo.save(clientMapper.dtoToClientEntity(clientDto));

            return new CommonResponseDto(201, "Client  saved!", clientDto.getClientName(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }
    
    @Override
    public CommonResponseDto updateClient(RequestRegistryDto dto, String clientId) {
        try {
            Client allClients = clientRepo.findByClientId(clientId);
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());

            allClients.setClientType(dto.getClientType());
            allClients.setClientName(dto.getClientName());
            allClients.setContactPersonName(dto.getContactPersonName());
            allClients.setClientPhoneNumbers(dto.getClientPhoneNumbers());
            allClients.setClientEmail(dto.getClientEmail());
            allClients.setClientRegisteredAddress(dto.getClientRegisteredAddress());
            allClients.setClientBillingAddress(dto.getClientBillingAddress());
            allClients.setClientCreatedBy(dto.getClientCreatedBy());
            allClients.setClientCreatedDate(dto.getClientCreatedDate());
            allClients.setClientModifiedBy(dto.getClientModifiedBy());
            allClients.setClientModifiedDate(dto.getClientModifiedDate());
            allClients.setStatus(status.get());
            clientRepo.save(allClients);

            return new CommonResponseDto(201, "Client  Updated!", allClients.getClientName(), new ArrayList<>());
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
                                r.getClientId(),
                                r.getClientType(),
                                r.getClientName(),
                                r.getContactPersonName(),
                                r.getClientPhoneNumbers(),
                                r.getClientEmail(),
                                r.getClientRegisteredAddress(),
                                r.getClientBillingAddress(),
                                r.getClientCreatedBy(),
                                r.getClientCreatedDate(),
                                r.getClientModifiedBy(),
                                r.getClientModifiedDate(),
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

    @Override
    public CommonResponseDto removeClient(String clientId) {

        Optional<Client> client = clientRepo.getClientsById(clientId);

        if (client.isPresent()) {
            clientRepo.delete(client.get());
            return new CommonResponseDto(201, "Client was deleted! ", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any Client---...!");
        }
    }

    @Override
    public PaginatedResponseClientDto allClient() {
        try {
            List<Client> allClientForProvidedId = clientRepo.findAll();
            List<ClientResponseDto> clientResponseDos = new ArrayList<>();

            for (Client r : allClientForProvidedId) {
                clientResponseDos.add(
                        new ClientResponseDto(
                                r.getClientId(),
                                r.getClientType(),
                                r.getClientName(),
                                r.getContactPersonName(),
                                r.getClientPhoneNumbers(),
                                r.getClientEmail(),
                                r.getClientRegisteredAddress(),
                                r.getClientBillingAddress(),
                                r.getClientCreatedBy(),
                                r.getClientCreatedDate(),
                                r.getClientModifiedBy(),
                                r.getClientModifiedDate(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }

            return new PaginatedResponseClientDto(
                    clientRepo.count(),
                    clientResponseDos
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }
}
