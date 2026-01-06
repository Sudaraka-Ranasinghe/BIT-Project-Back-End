//package com.edu.Institiute.repo;
//
//import com.edu.Institiute.entity.Department;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface DepartmentRepo {
//    @Query(value = "SELECT * FROM department WHERE id=:departmentId", nativeQuery = true)
//    Department getAllDepartmentForProvidedId(@Param("departmentId") String departmentId);
//
//    @Query(value = "SELECT * FROM department WHERE id=:departmentId", nativeQuery = true)
//    Optional<Department> getDepartmentById(@Param("departmentId") String departmentId);
//
////    @Query(value = "SELECT * FROM course WHERE coursename=:courseName", nativeQuery = true)
////    Optional<Course> findCourseByName(@Param("courseName") String courseName);
//}
