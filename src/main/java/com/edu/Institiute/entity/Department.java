package com.edu.Institiute.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "departmentId")
    private String departmentId;

    @Column(name = "departmentName")
    private String departmentName;

    @Column(name = "departmentCreatedBy")
    private String departmentCreatedBy;

    @Column(name = "departmentCreatedDate")
    private Date departmentCreatedDate;

    @Column(name = "departmentModifiedBy")
    private String departmentModifiedBy;

    @Column(name = "departmentModifiedDate")
    private Date departmentModifiedDate;

    @ManyToOne
    @JoinColumn(name ="statusid",referencedColumnName = "id")
    private Status Status;
}
