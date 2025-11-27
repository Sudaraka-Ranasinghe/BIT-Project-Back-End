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
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employeeId")
    private String employeeId;

    @Column(name = "employeeFirstName")
    private String employeeFirstName;

    @Column(name = "employeeLastName")
    private String employeeLastName;

    @Column(name = "employeeNICNumber", unique = true)
    private String employeeNICNumber;

    @Column(name = "employeeOfficialEmail")
    private String employeeOfficialEmail;

    @Column(name= "employeeDateOfBirth")
    private Date employeeDateOfBirth;

    @Column(name = "employeeAddress")
    private String employeeAddress;

    @Column(name = "employeeContact")
    private Number employeeContact;

    @Column(name = "employmentDate")
    private Date employmentDate;

    @Column(name = "employeeStatus")
    private String employeeStatus;

    @Column(name = "employeeCreatedBy")
    private String employeeCreatedBy;

    @Column(name = "employeeCreatedDate")
    private Date employeeCreatedDate;

    @Column(name = "employeeModifiedBy")
    private String employeeModifiedBy;

    @Column(name = "employeeModifiedDate")
    private Date employeeModifiedDate;

    @ManyToOne
    @JoinColumn(name ="statusId",referencedColumnName = "id")
    private Status Status;
}
