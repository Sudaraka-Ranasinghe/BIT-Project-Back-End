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
@Table(name = "surveyProject")
public class SurveyProject {

    @Id
    @Column(name = "projectId")
    private String projectId;

    @Column(name = "projectTitle")
    private String projectTitle;

    @Column(name = "projectDescription")
    private String projectDescription;

    @Column(name = "officialStartDate")
    private Date officialStartDate;

    @Column(name = "estimatedEndDate")
    private Date estimatedEndDate;

    @Column(name = "actualEndDate")
    private Date actualEndDate;

    @Column(name = "projectLocation")
    private String projectLocation;

    @Column(name = "projectValue")
    private String projectValue;

    @Column(name = "projectCreatedBy")
    private String projectCreatedBy;

    @Column(name = "projecteCreatedDate")
    private Date projectCreatedDate;

    @Column(name = "projectModifiedBy")
    private String projectModifiedBy;

    @Column(name = "projectModifiedDate")
    private Date projectModifiedDate;

    @ManyToOne
    @JoinColumn(name ="statusId",referencedColumnName = "id")
    private Status Status;

    @ManyToOne
    @JoinColumn(name ="surveyRequestId",referencedColumnName = "surveyRequestId")
    private SurveyRequest SurveyRequest;
}
