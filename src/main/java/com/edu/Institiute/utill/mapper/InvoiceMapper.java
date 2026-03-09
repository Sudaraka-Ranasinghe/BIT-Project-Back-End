package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.InvoiceDto;
import com.edu.Institiute.entity.Invoice;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice dtoToInvoiceEntity(InvoiceDto invoiceDto);
    InvoiceDto toInvoiceDto(Invoice invoice);
}
