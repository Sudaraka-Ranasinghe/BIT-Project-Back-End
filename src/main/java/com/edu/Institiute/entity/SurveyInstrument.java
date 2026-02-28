package com.edu.Institiute.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="surveyInstrument")
public class SurveyInstrument {

    @Id
    @Column(name ="surveyInstrumentId")
    private String surveyInstrumentId;

    @Column(name = "instrumentName")
    private String instrumentName;

    @Column(name = "serialNumber", unique = true)
    private String serialNumber;

    @Column(name = "instrumentType")
    private String instrumentType;

    @Column(name = "calibrationDate")
    private Date calibrationDate;

    @Column(name = "nextCalibrationDue")
    private String nextCalibrationDue;

    @Column(name = "instrumentCreatedBy")
    private String instrumentCreatedBy;

    @Column(name = "instrumentCreatedDate")
    private Date instrumentCreatedDate;

    @Column(name = "instrumentModifiedBy")
    private String instrumentModifiedBy;

    @Column(name = "instrumentModifiedDate")
    private Date instrumentModifiedDate;

    @ManyToOne
    @JoinColumn(name ="statusId",referencedColumnName = "id")
    private Status Status;
}
