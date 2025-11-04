package com.edu.Institiute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String id;
    private String clientFullName;
    private String clientNic;
    private String clientAddress;
    private String clientEmail;
    private Number clientContact;
    private String clientCreatedBy;
    private Date clientCreatedDate;
    private String clientModifyBy;
    private Date clientModifyDate;
    private StatusDto status;

}
