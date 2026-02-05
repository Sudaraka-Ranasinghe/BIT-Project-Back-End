package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseClientDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public interface ClientService {
    CommonResponseDto saveClient(RequestRegistryDto dto);

    CommonResponseDto updateClient(RequestRegistryDto dto, String clientId);

    PaginatedResponseClientDto clientById(String clientCode) throws SQLException;

    CommonResponseDto removeClient(String clientId);

    PaginatedResponseClientDto allClient() throws SQLException;
}
