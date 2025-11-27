package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String clientId;
    private String clientType;
    private String clientName;
    private String contactPersonName;
    private Number clientPhoneNumbers;
    private String clientEmail;
    private String clientRegisteredAddress;
    private String clientBillingAddress;
    private String clientCreatedBy;
    private Date clientCreatedDate;
    private String clientModifiedBy;
    private Date clientModifiedDate;
    private StatusDto Status;

}
