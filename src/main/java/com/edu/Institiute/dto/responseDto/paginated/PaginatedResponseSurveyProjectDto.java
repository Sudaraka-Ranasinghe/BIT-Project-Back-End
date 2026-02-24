package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.SurveyProjectResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseSurveyProjectDto {
    private Long count;
    private List<SurveyProjectResponseDto> dataList;
}
