package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,String> {
    @Query(value = "SELECT * FROM employee WHERE employee_id=:employeeId", nativeQuery = true)
    Employee findByEmployeeId(@Param("employeeId") String employeeId);

    @Query(value = "SELECT * FROM employee WHERE employee_id=:employeeCode", nativeQuery = true)
    List<Employee> getAllEmployeeForProvidedId(@Param("employeeCode") String employeeCode);

    @Query(value = "SELECT * FROM employee WHERE employee_id=:employeeId", nativeQuery = true)
    Optional<Employee> getEmployeesById(@Param("employeeId")String employeeId);

    @Query(value = "SELECT * FROM employee WHERE employeenicnumber=:employeNICNumber", nativeQuery = true)
    Optional<Employee> getEmployeesByNIC(@Param("employeNICNumber")String employeNICNumber);

    @Query(value = "SELECT * FROM employee WHERE employee_id=:employeeId", nativeQuery = true)
    Optional<Employee> findByExxEmployeeId(@Param("employeeId") String employeeId);
}
