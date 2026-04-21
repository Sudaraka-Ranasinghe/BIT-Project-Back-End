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
//@Table(name = "surveyPoint")
//public class SurveyPoint {
//
//    @Id
//    @Column(name = "surveyPointId")
//    private String surveyPointId;
//
//    @Column(name = "north")
//    private Float north;
//
//    @Column(name = "east")
//    private Float east;
//
//    @Column(name = "elevation")
//    private Float elevation;
//
//    @Column(name = "pointDescription")
//    private String pointDescription;
//
//    @Column(name = "pointType")
//    private String pointType;
//
//    @Column(name = "pointCreatedBy")
//    private String pointCreatedBy;
//
//    @Column(name = "pointCreatedDate")
//    private Date pointCreatedDate;
//
//    @Column(name = "pointModifiedBy")
//    private String pointModifiedBy;
//
//    @Column(name = "pointModifiedDate")
//    private Date pointModifiedDate;
//
//    @ManyToOne
//    @JoinColumn(name ="projectId",referencedColumnName = "projectId")
//    private SurveyProject SurveyProject;
//}
