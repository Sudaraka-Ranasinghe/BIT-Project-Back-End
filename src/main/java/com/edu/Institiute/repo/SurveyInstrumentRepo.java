package com.edu.Institiute.repo;

import com.edu.Institiute.entity.SurveyInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyInstrumentRepo extends JpaRepository<SurveyInstrument,String> {
    @Query(value = "SELECT * FROM surveyInstrument WHERE survey_Instrument_id=:surveyInstrumentId", nativeQuery = true)
    SurveyInstrument findBySurveyInstrumentId(@Param("surveyInstrumentId") String surveyInstrumentId);

    @Query(value = "SELECT * FROM surveyInstrument WHERE survey_Instrument_id=:surveyInstrumentCode", nativeQuery = true)
    List<SurveyInstrument> getAllSurveyInstrumentForProvidedId(@Param("surveyorCode") String surveyorCode);

    @Query(value = "SELECT * FROM surveyInstrument WHERE survey_Instrument_id=:surveyInstrumentId", nativeQuery = true)
    Optional<SurveyInstrument> getSurveyInstrumentById(@Param("surveyInstrumentId")String surveyInstrumentId);
}
