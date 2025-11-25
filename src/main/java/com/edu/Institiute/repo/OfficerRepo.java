package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Client;
import com.edu.Institiute.entity.Officer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfficerRepo extends JpaRepository<Officer,String> {
    @Query(value = "SELECT * FROM officer WHERE id=:officerId", nativeQuery = true)
    Officer findByOfficerId(@Param("officerId") String officerId);

    @Query(value = "SELECT * FROM officer WHERE id=:officerCode", nativeQuery = true)
    List<Officer> getAllOfficerForProvidedId(@Param("officerCode") String officerCode);

    @Query(value = "SELECT * FROM officer WHERE id=:officerId", nativeQuery = true)
    Optional<Officer> getOfficersById(@Param("officerId")String officerId);
}
