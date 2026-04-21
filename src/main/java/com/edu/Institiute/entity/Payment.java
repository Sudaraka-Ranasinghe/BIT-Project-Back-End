//package com.edu.Institiute.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@RequiredArgsConstructor
//public class Payment {
//
//    @Id
//    @Column(name = "paymentId")
//    private String paymentId;
//
//    @Column(name = "paymentDate")
//    private Date paymentDate;
//
//    @Column(name = "amountPaid")
//    private Float amountPaid;
//
//    @Column(name = "PaymentMethod")
//    private String paymentMethod;
//
//    @Column(name = "transactionReference")
//    private String transactionReference;
//
//    @Column(name = "receivedBy")
//    private String receivedBy;
//
//    @Column(name = "paymentCreatedBy")
//    private String paymentCreatedBy;
//
//    @Column(name = "paymentCreatedDate")
//    private Date paymentCreatedDate
//            ;
//    @Column(name = "paymentModifiedBy")
//    private String paymentModifiedBy;
//
//    @Column(name = "PaymentModifiedDate")
//    private Date paymentModifiedDate;
//
//    @ManyToOne
//    @JoinColumn(name ="statusId",referencedColumnName = "id")
//    private Status Status;
//
//    @ManyToOne
//    @JoinColumn(name ="invoiceId",referencedColumnName = "invoiceId")
//    private Invoice Invoice;
//
//    @ManyToOne
//    @JoinColumn(name ="adminStaffId",referencedColumnName = "adminStaffId")
//    private AdminStaff AdminStaff;
//
//}
