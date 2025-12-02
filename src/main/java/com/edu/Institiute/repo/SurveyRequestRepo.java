package com.edu.Institiute.repo;

import com.edu.Institiute.entity.SurveyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRequestRepo extends JpaRepository<SurveyRequest,String> {
    @Query(value = "SELECT * FROM surveyRequest WHERE id=:surveyRequestId", nativeQuery = true)
    SurveyRequest findBySurveyRequestId(@Param("surveyRequestId") String surveyRequestId);

    @Query(value = "SELECT * FROM surveyRequest WHERE id=:surveyRequestCode", nativeQuery = true)
    List<SurveyRequest> getAllSurveyRequestForProvidedId(@Param("surveyRequestCode") String surveyRequestCode);

    @Query(value = "SELECT * FROM surveyRequest WHERE id=:surveyRequestId", nativeQuery = true)
    Optional<SurveyRequest> getSurveyRequestsById(@Param("surveyRequestId")String surveyRequestId);
}
