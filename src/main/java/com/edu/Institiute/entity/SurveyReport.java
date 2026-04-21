//package com.edu.Institiute.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Getter
//@Setter
//@RequiredArgsConstructor
//@AllArgsConstructor
//@Table(name = "surveyreport")
//public class SurveyReport {
//
//    @Id
//    @Column(name = "reportId")
//    private String reportId;
//
//    @Column(name = "reportTitle")
//    private String reportTitle;
//
//    @Column(name = "reportData")
//    private String reportData;
//
//    @Column(name = "summary")
//    private String summary;
//
//    @Column(name = "generatedDate")
//    private Date generatedDate;
//
//    @Column(name = "approvalDate")
//    private Date approvalDate;
//
//    @Column(name = "reportCreatedBy")
//    private String reportCreatedBy;
//
//    @Column(name = "reportCreatedDate")
//    private Date reportCreatedDate;
//
//    @Column(name = "reportModifiedBy")
//    private String reportModifiedBy;
//
//    @Column(name = "reportModifiedDate")
//    private Date reportModifiedDate;
//
//    @ManyToOne
//    @JoinColumn(name ="statusId",referencedColumnName = "id")
//    private Status status;
//
//    @ManyToOne
//    @JoinColumn(name ="projectId",referencedColumnName = "projectId")
//    private SurveyProject surveyProject;
//
//    @ManyToOne
//    @JoinColumn(name ="approvedBy",referencedColumnName = "surveyorId")
//    private Surveyor surveyor;
//
//}
