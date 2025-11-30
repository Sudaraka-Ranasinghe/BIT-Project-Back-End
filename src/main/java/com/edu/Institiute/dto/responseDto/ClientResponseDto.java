package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
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
