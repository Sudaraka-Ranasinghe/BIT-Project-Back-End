package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClientDto {

    private String id;
    private String fullName;
    private String nic;
    private String address;
    private String email;
    private Number contact;
    private String createdBy;
    private Date createdDate;
    private String modifyBy;
    private Date modifyDate;
    private StatusDto Status;
}
