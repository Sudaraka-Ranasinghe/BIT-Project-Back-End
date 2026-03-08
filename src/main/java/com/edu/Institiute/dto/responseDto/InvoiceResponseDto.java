package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.ClientDto;
import com.edu.Institiute.dto.StatusDto;
import com.edu.Institiute.dto.SurveyProjectDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponseDto {
    private String invoiceId;
    private Date issueDate;
    private Date dueDate;
    private Float amount;
    private Float taxAmount;
    private Float totalAmount;
    private String invoiceCreatedBy;
    private Date invoiceCreatedDate;
    private String invoiceModifiedBy;
    private Date invoiceModifiedDate;
    private StatusDto Status;
    private SurveyProjectDto ProjectId;
    private ClientDto ClientId;
}
