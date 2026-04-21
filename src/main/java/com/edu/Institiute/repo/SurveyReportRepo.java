//package com.edu.Institiute.repo;
//
//import com.edu.Institiute.entity.SurveyReport;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//@Repository
//public interface SurveyReportRepo extends JpaRepository<SurveyReport,String> {
//    @Query(value = "SELECT * FROM surveyReport WHERE report_id=:reportId", nativeQuery = true)
//    SurveyReport findByReportId(@Param("reportId") String reportId);
//
//    @Query(value = "SELECT * FROM surveyReport WHERE report_id=:reportCode", nativeQuery = true)
//    List<SurveyReport> getAllReportForProvidedId(@Param("reportCode") String reportCode);
//
//    @Query(value = "SELECT * FROM surveyReport WHERE report_id=:reportId", nativeQuery = true)
//    Optional<SurveyReport> getReportById(@Param("reportId")String reportId);
//}
