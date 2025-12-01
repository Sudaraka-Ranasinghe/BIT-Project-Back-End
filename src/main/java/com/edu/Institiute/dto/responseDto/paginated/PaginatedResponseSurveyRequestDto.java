package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.SurveyRequestResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseSurveyRequestDto {
    private Long count;
    private List<SurveyRequestResponseDto> dataList;
}
