package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface LandParcelService {
    CommonResponseDto saveLandParcel(RequestRegistryDto dto);
}
