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
    @Column(name = "id")
    private String id;

    @Column(name = "fullname")
    private String clientFullName;

    @Column(name = "clientNic")
    private String clientNic;

    @Column(name = "clientAddress")
    private String clientAddress;

    @Column(name = "clientEmail")
    private String clientEmail;

    @Column(name = "clientContact")
    private Number clientContact;

    @Column(name = "clientCreatedBy")
    private String clientCreatedBy;

    @Column(name = "clientCreatedDate")
    private Date clientCreatedDate;

    @Column(name = "clientModifyBy")
    private String clientModifyBy;

    @Column(name = "clientModifyDate")
    private Date clientModifyDate;

    @ManyToOne
    @JoinColumn(name ="statusid",referencedColumnName = "id")
    private Status Status;

}
