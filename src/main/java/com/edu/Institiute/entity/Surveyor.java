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
//@Table(name = "surveyor")
//public class Surveyor {
//
//    @Id
//    @Column(name = "surveyorId")
//    private String surveyorId;
//
//    @Column(name = "surveyorLicenseNumber", unique = true)
//    private String surveyorLicenseNumber;
//
//    @Column(name = "surveyorLicenseExpiryDate")
//    private Date surveyorLicenseExpiryDate;
//
//    @Column(name = "surveyorSpecialization")
//    private String surveyorSpecialization;
//
//    @Column(name ="surveyorRank")
//    private String surveyorRank;
//
//    @OneToOne
//    @JoinColumn(name ="employeeId",referencedColumnName = "employeeId")
//    private Employee Employee;
//
//}
