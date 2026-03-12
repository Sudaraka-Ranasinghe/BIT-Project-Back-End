package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.AdminStaffResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponseAdminStaffDto {
    private Long count;
    private List<AdminStaffResponseDto> dataList;
}
