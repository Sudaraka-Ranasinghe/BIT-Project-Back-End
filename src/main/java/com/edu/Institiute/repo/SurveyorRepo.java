package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Surveyor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyorRepo extends JpaRepository<Surveyor,String> {

    @Query(value = "SELECT * FROM surveyor WHERE surveyor_id=:surveyorId", nativeQuery = true)
    Surveyor findBySurveyorId(@Param("surveyorId") String surveyorId);

    @Query(value = "SELECT * FROM surveyor WHERE surveyor_id=:surveyorCode", nativeQuery = true)
    List<Surveyor> getAllSurveyorForProvidedId(@Param("surveyorCode") String surveyorCode);

    @Query(value = "SELECT * FROM surveyor WHERE surveyor_id=:surveyorId", nativeQuery = true)
    Optional<Surveyor> getSurveyorById(@Param("surveyorId")String surveyorId);

    @Query(value = "SELECT * FROM surveyor WHERE surveyor_id=:surveyorId", nativeQuery = true)
    Optional<Surveyor> findByExxSurveyorId(@Param("surveyorId") String surveyorId);
}
