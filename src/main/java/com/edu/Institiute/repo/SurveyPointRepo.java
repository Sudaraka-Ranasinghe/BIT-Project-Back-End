//package com.edu.Institiute.repo;
//
//import com.edu.Institiute.entity.SurveyPoint;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface SurveyPointRepo extends JpaRepository<SurveyPoint,Long> {
//    @Query(value = "SELECT * FROM surveyPoint WHERE survey_Point_id=:surveyPointId", nativeQuery = true)
//    SurveyPoint findBySurveyPointId(@Param("surveyPointId") String surveyPointId);
//
//    @Query(value = "SELECT * FROM surveyPoint WHERE survey_Point_id=:surveyPointCode", nativeQuery = true)
//    List<SurveyPoint> getAllSurveyPointForProvidedId(@Param("surveyPointCode") String surveyorCode);
//
//    @Query(value = "SELECT * FROM surveyPoint WHERE survey_Point_id=:surveyPointId", nativeQuery = true)
//    Optional<SurveyPoint> getSurveyPointById(@Param("surveyPointId")String surveyPointId);
//}
