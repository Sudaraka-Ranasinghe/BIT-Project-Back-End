//package com.edu.Institiute.service.impl;
//
//
//import com.edu.Institiute.dto.DepartmentDto;
//import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
//import com.edu.Institiute.dto.responseDto.CommonResponseDto;
//import com.edu.Institiute.dto.responseDto.DepartmentResponseDto;
//import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseDepartmentDto;
//import com.edu.Institiute.entity.Department;
//import com.edu.Institiute.exception.EntryNotFoundException;
//import com.edu.Institiute.service.DepartmentService;
//import com.edu.Institiute.utill.Generator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class DepartmentRegistryImpl implements DepartmentService {
//
//    @Autowired
//    private Generator generator;
//
//    @Autowired
//    private DeapartmentMapper departmentMapper;
//
//    @Autowired
//    private DeapartmentRepo dapartmentRepo;
//
////    @Autowired
////    private OfficerHasDeapartmentRepo officerHasDeapartmentRepo;
//
//    @Override
//    public CommonResponseDto saveDepartment(RequestRegistryDto dto) {
//        try {
//            String departmentRegistryCode = "IBM-C" + "-" + generator.generateFourNumbers();
//            String departmentId =  generator.generateFourNumbers();
//
//            DepartmentDto departmentDto = new DepartmentDto(
//                    departmentId,
//                    dto.getDepartmentName(),
//                    dto.getDepartmentCreatedBy(),
//                    dto.getDepartmentCreatedDate(),
//                    dto.getDepartmentModifiedBy(),
//                    dto.getDepartmentModifiedDate(),
//                    statusMapper.toStatusDto(status.get())
//            );
//            departmentRepo.save(departmentMapper.dtoToDepartmentEntity(departmentDto));
//
//            return new CommonResponseDto(201, "Department  saved!", departmentDto.getDepartmentName(), new ArrayList<>());
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
//        }
//    }
//
//    @Override
//    public CommonResponseDto updateDepartment(RequestRegistryDto dto, String departmentId) {
//        try {
//
//            Department allDepartmentForProvidedId = departmentRepo.getAllDepartmentForProvidedId(departmentId);
//            allDepartmentForProvidedId.setDepartmentName(dto.getDepartmentName());
//            allDepartmentForProvidedId.setDepartmentCreatedBy(dto.getDepartmentCreatedBy());
//            allDepartmentForProvidedId.setDepartmentCreatedDate(dto.getDepartmentCreatedDate());
//            allDepartmentForProvidedId.setDepartmentModifiedBy(dto.getDepartmentModifiedBy());
//            allDepartmentForProvidedId.setDepartmentCreatedDate(dto.getDepartmentCreatedDate());
//            allDepartments.setStatus(status.get());
//            departmentRepo.save(allDepartmentForProvidedId);
//
//            return new CommonResponseDto(201, "Department  Updated!", allDepartmentForProvidedId.getDepartmentId(), new ArrayList<>());
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
//        }
//    }
//
////    @Override
////    public CommonResponseDto removeDepartment(String departmentId) {
////        Optional<Department> department = departmentRepo.getDeparmentById(departmentId);
////        List<OfficerHasDepartment> officerHasDepartments= officerHasDepartmentRepo.getOfficerAndDepartment(departmenId);
////
////        if (!officerHasDepartment.isEmpty()){
////            for (OfficerHasDepartment r : officerHasDepartments){
////                officerHasDepartmentRepo.deleteById(r.getId());
////            }
////        }
////
////        if (Department.isPresent()) {
////            departmentRepo.delete(department.get());
////            return new CommonResponseDto(201, "Department was deleted!", true, new ArrayList<>());
////        } else {
////            throw new EntryNotFoundException("Can't find any Officer...!");
////        }
////    }
//
//    @Override
//    public PaginatedResponseDepartmentDto allDepartment() throws SQLException {
//        try {
//            List<Department> allDepartmentForProvidedId = departmentRepo.findAll();
//            List<DepartmentResponseDto> departmentResponseDos = new ArrayList<>();
//
//            for (Department r : allDepartmentForProvidedId) {
//                departmentResponseDos.add(
//                        new DepartmentResponseDto(
//                                r.getDepartmentId(),
//                                r.getDepartmentName(),
//                                r.getDepartmentCreatedBy(),
//                                r.getDepartmentCreatedDate(),
//                                r.getDepartmentModifiedBy(),
//                                r.getDepartmentModifiedDate(),
//                                statusMapper.toStatusDto(r.getStatus())
//                        )
//                );
//            }
//            return new PaginatedResponseDepartmentDto(
//                    departmentRepo.count(),
//                    departmentResponseDos
//            );
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't find any data...!");
//        }
//    }
//}
