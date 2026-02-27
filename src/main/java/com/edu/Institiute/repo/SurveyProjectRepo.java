package com.edu.Institiute.repo;

import com.edu.Institiute.entity.SurveyProject;
import com.edu.Institiute.entity.SurveyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyProjectRepo extends JpaRepository<SurveyProject,Integer> {
    @Query(value = "SELECT * FROM surveyProject WHERE project_id=:projectId", nativeQuery = true)
    SurveyProject findByProjectId(@Param("projectId") String projectId);

    @Query(value = "SELECT * FROM surveyProject WHERE project_id=:projectCode", nativeQuery = true)
    List<SurveyProject> getAllProjectForProvidedId(@Param("surveyorCode") String surveyorCode);

    @Query(value = "SELECT * FROM surveyProject WHERE project_id=:projectId", nativeQuery = true)
    Optional<SurveyProject> getProjectById(@Param("projectId")String projectId);

    @Query(value = "SELECT * FROM surveyProject WHERE survey_project_id=:surveyProjectId", nativeQuery = true)
    Optional<SurveyProject> findByExxSurveyProjectId(@Param("surveyProjectId") String surveyProjectId);
}
