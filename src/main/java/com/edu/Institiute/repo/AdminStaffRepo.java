package com.edu.Institiute.repo;

import com.edu.Institiute.entity.AdminStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminStaffRepo extends JpaRepository<AdminStaff,String> {

    @Query(value = "SELECT * FROM adminstaff WHERE admin_staff_id=:adminStaffId", nativeQuery = true)
    AdminStaff findByAdminStaffId(@Param("adminStaffId") String adminStaffId);

    @Query(value = "SELECT * FROM adminstaff WHERE admin_staff_id=:adminStaffId", nativeQuery = true)
    List<AdminStaff> getAllAdminStaffForProvidedId(@Param("adminStaffId") String adminStaffId);

    @Query(value = "SELECT * FROM adminstaff WHERE admin_staff_id=:adminStaffId", nativeQuery = true)
    Optional<AdminStaff> getAdminStaffById(@Param("adminStaffId")String adminStaffId);

    @Query(value = "SELECT * FROM adminstaff WHERE admin_staff_id=:adminStaffId", nativeQuery = true)
    Optional<AdminStaff> findByExxAdminStaffId(@Param("adminStaffId") String adminStaffId);
}
