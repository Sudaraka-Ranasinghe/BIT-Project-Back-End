package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.AdminStaffDto;
import com.edu.Institiute.entity.AdminStaff;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface AdminStaffMapper {
    AdminStaff dtoToAdminStaffEntity(AdminStaffDto adminStaffDto);
    AdminStaffDto toAdminStaffDto(AdminStaff adminStaff);
}
