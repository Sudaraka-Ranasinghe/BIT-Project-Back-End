package com.edu.Institiute.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "invoice")
public class Invoice {

    @Id
    @Column(name = "invoiceId")
    private String invoiceId;

    @Column(name = "issueDate")
    private Date issueDate;

    @Column(name = "dueDate")
    private Date dueDate;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "taxAmount")
    private Float taxAmount;

    @Column(name = "totalAmount")
    private Float totalAmount;

    @Column(name = "invoieCreatedBy")
    private String invoiceCreatedBy;

    @Column(name = "invoiceCreatedDate")
    private Date invoiceCreatedDate;

    @Column(name = "invoieModifiedBy")
    private String invoiceModifiedBy;

    @Column(name = "invoiceModifiedDate")
    private Date invoiceModifiedDate;

    @ManyToOne
    @JoinColumn(name ="statusId",referencedColumnName = "id")
    private Status Status;

    @ManyToOne
    @JoinColumn(name ="projectId",referencedColumnName = "projectId")
    private SurveyProject SurveyProject;

    @ManyToOne
    @JoinColumn(name ="clientId",referencedColumnName = "clientId")
    private Client Client;

}
