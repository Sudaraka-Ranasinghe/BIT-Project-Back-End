package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.SurveyInstrumentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseSurveyInstrumentDto {
    private Long count;
    private List<SurveyInstrumentResponseDto> dataList;
}
