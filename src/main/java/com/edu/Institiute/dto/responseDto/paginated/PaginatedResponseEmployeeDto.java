package com.edu.Institiute.dto.responseDto.paginated;


import com.edu.Institiute.dto.responseDto.EmployeeResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseEmployeeDto {
    private Long count;
    private List<EmployeeResponseDto> dataList;
}
