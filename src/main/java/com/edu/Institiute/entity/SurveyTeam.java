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
@Table(name = "surveyteam")
public class SurveyTeam {

    @Id
    @Column(name = "surveyTeamId")
    private String surveyTeamId;

    @Column(name ="teamRole")
    private String teamRole;

    @Column(name ="assignedDate")
    private Date assignedDate;

    @Column(name ="releasedDate")
    private Date releasedDate;

    @Column(name ="teamCreatedBy")
    private String teamCreatedBy;

    @Column(name ="teamCreatedDate")
    private Date teamCreatedDate;

    @Column(name ="teamModifiedBy")
    private String teamModifiedBy;

    @Column(name ="teamModifiedDate")
    private Date teamModifiedDate;

    @ManyToOne
    @JoinColumn(name ="statusId",referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name ="projectId",referencedColumnName = "projectId")
    private SurveyProject surveyproject;

    @ManyToOne
    @JoinColumn(name ="surveyorId",referencedColumnName = "surveyorId")
    private Surveyor surveyor;

}
