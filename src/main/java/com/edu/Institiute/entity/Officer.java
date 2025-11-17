package com.edu.Institiute.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "officer")
public class Officer {
    @Id
    @Column(name = "officerId")
    private String officerId;

    @Column(name = "officerFullName")
    private String officerFullName;

    @Column(name = "officerType")
    private String officerType;

    @Column(name = "officerCreatedBy")
    private String officerCreatedBy;

    @Column(name = "officerCreatedDate")
    private Date officerCreatedDate;

    @Column(name = "officerModifyBy")
    private String officerModifyBy;

    @Column(name = "officerModifyDate")
    private Date officerModifyDate;

    @ManyToOne
    @JoinColumn(name ="statusid",referencedColumnName = "officerId")
    private Status Status;

    @OneToMany(mappedBy = "officerId", cascade = CascadeType.ALL)
    private List<OfficerHasDepartment> officerHasDepartment;


    // id
    // officername
    // officertype
    // department
    // createdby
    // createdDate
    // modify by
    // modify date
    // status
}
