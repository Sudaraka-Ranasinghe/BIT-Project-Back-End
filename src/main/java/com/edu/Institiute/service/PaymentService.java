package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    CommonResponseDto savePayment(RequestRegistryDto dto);
}
