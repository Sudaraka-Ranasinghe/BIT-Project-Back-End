package com.edu.Institiute.entity;

//import com.edu.Institiute.api.DepartmentController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@RequiredArgsConstructor
//@AllArgsConstructor
//@Table(name = "officer")
//public class Officer {
//    @Id
//    @Column(name = "officerId")
//    private String officerId;
//
//    @Column(name = "officerFullName")
//    private String officerFullName;
//
//    @Column(name = "officerType")
//    private String officerType;
//
//    @Column(name = "officerCreatedBy")
//    private String officerCreatedBy;
//
//    @Column(name = "officerCreatedDate")
//    private Date officerCreatedDate;
//
//    @Column(name = "officerModifyBy")
//    private String officerModifyBy;
//
//    @Column(name = "officerModifyDate")
//    private Date officerModifiedDate;
//
//    @ManyToOne
//    @JoinColumn(name ="statusid",referencedColumnName = "id")
//    private Status Status;
//
//    @ManyToOne
//    @JoinColumn(name ="departmentid",referencedColumnName = "departmentId")
//    private Department Department;
//}
