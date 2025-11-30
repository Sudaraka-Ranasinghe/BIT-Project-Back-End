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
@Table(name = "surveyRequest")
public class SurveyRequest {

    @Id
    @Column(name = "surveyRequestId")
    private String surveyRequestId;

    @Column(name = "requestDescription")
    private String requestDescription;

    @Column(name = "RequestDate")
    private Date requestDate;

    @Column(name = "preferredDueDate")
    private Date preferredDueDate;

    @Column(name = "locationDescription")
    private String locationDescription;

    @Column(name = "purposeOfSurvey")
    private String purposeOfSurvey;

    @Column(name = "assignedAdminID")
    private String assignedAdminID;

    @Column(name = "requestCreatedBy")
    private String requestCreatedBy;

    @Column(name = "requestCreatedDate")
    private Date requestCreatedDate;

    @Column(name = "requestModifiedBy")
    private String requestModifiedBy;

    @Column(name = "requestModifiedDate")
    private Date requestModifiedDate;

    @ManyToOne
    @JoinColumn(name ="statusid",referencedColumnName = "id")
    private Status Status;

    @ManyToOne
    @JoinColumn(name ="clientId",referencedColumnName = "clientId")
    private Client Client;
}
