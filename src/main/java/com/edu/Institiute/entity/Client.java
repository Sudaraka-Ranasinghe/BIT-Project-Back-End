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
@Table (name = "client")
public class Client {

    @Id
    @Column(name = "clientId")
    private String clientId;

    @Column(name = "clientType")
    private String clientType;

    @Column(name = "clientName")
    private String clientName;

    @Column(name = "contactPersonName")
    private String contactPersonName;

    @Column(name = "clientPhoneNumbers")
    private Number clientPhoneNumbers;

    @Column(name = "clientEmail")
    private String clientEmail;

    @Column(name = "clientRegisteredAddress")
    private String clientRegisteredAddress;

    @Column(name = "clientBillingAddress")
    private String clientBillingAddress;

    @Column(name = "clientCreatedBy")
    private String clientCreatedBy;

    @Column(name = "clientCreatedDate")
    private Date clientCreatedDate;

    @Column(name = "clientModifiedBy")
    private String clientModifiedBy;

    @Column(name = "clientModifiedDate")
    private Date clientModifiedDate;

    @ManyToOne
    @JoinColumn(name ="statusid",referencedColumnName = "id")
    private Status Status;

}
