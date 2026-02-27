package com.edu.Institiute.repo;

import com.edu.Institiute.entity.SurveyTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyTeamRepo extends JpaRepository<SurveyTeam,String> {

    @Query(value = "SELECT * FROM surveyTeam WHERE survey_team_id=:surveyTeamId", nativeQuery = true)
    SurveyTeam findBySurveyTeamId(@Param("surveyTeamId") String surveyTeamId);

    @Query(value = "SELECT * FROM surveyTeam WHERE survey_team_id=:surveyTeamCode", nativeQuery = true)
    List<SurveyTeam> getAllSurveyTeamForProvidedId(@Param("surveyTeamCode") String surveyTeamCode);

    @Query(value = "SELECT * FROM surveyTeam WHERE survey_team_id=:surveyTeamId", nativeQuery = true)
    Optional<SurveyTeam> getSurveyTeamById(@Param("surveyTeamId")String surveyTeamId);
}
