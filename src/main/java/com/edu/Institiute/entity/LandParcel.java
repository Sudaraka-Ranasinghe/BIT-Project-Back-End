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
//@Setter
//@Getter
//@RequiredArgsConstructor
//@AllArgsConstructor
//@Table(name = "landParcel")
//public class LandParcel {
//
//    @Id
//    @Column(name = "landParcelId")
//    private String landParcelId;
//
//    @Column(name = "titleDeedNumber")
//    private String titleDeedNumber;
//
//    @Column(name = "area")
//    private String area;
//
//    @Column(name = "address")
//    private String address;
//
//    @Column(name = "createdBy")
//    private String createdBy;
//
//    @Column(name = "createdDate")
//    private Date createdDate;
//
//    @Column(name = "modifiedBy")
//    private String modifiedBy;
//
//    @Column(name = "modifiedDate")
//    private Date modifiedDate;
//
//    @ManyToOne
//    @JoinColumn(name ="statusId", referencedColumnName = "id")
//    private Status status;
//
//    @ManyToOne
//    @JoinColumn(name = "projectId", referencedColumnName = "porjectId")
//    private SurveyProject surveyProject;
//}
