package com.edu.Institiute.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class AdminStaff {

    @Id
    @Column(name = "adminStaffId")
    private String adminStaffId;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name ="employeeId",referencedColumnName = "employeeId")
    private Employee Employee;
}
