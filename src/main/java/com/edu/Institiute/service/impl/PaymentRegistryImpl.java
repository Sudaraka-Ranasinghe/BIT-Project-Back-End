package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.PaymentDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.AdminStaff;
import com.edu.Institiute.entity.Invoice;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.AdminStaffRepo;
import com.edu.Institiute.repo.InvoiceRepo;
import com.edu.Institiute.repo.PaymentRepo;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.service.PaymentService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.AdminStaffMapper;
import com.edu.Institiute.utill.mapper.InvoiceMapper;
import com.edu.Institiute.utill.mapper.PaymentMapper;
import com.edu.Institiute.utill.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class PaymentRegistryImpl implements PaymentService {

    @Autowired
    private Generator generator;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private AdminStaffRepo adminStaffRepo;

    @Autowired
    private AdminStaffMapper adminStaffMapper;

    @Autowired
    private InvoiceRepo invoiceRepo;

    @Autowired
    private InvoiceMapper invoiceMapper;

    // For save Payment
    @Override
    public CommonResponseDto savePayment(RequestRegistryDto dto) {
        Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
        // To Check if invoiceId already exists
        Optional<Invoice> exxInvoice = invoiceRepo.findByExxInvoiceId((dto.getInvoiceId()));
        // To Check if adminStaffId already exists
        Optional<AdminStaff> exxAdminStaff = adminStaffRepo.findByExxAdminStaffId(dto.getAdminStaffId());

        if (!exxInvoice.isEmpty() && !exxAdminStaff.isEmpty()) {
            try {
                String paymentId = generator.generateFourNumbers();
                PaymentDto paymentDto = new PaymentDto(
                        paymentId,
                        dto.getPaymentDate(),
                        dto.getAmountPaid(),
                        dto.getPaymentMethod(),
                        dto.getTransactionReference(),
                        dto.getReceivedBy(),
                        dto.getPaymentCreatedBy(),
                        dto.getPaymentCreatedDate(),
                        dto.getPaymentModifiedBy(),
                        dto.getPaymentModifiedDate(),
                        statusMapper.toStatusDto(status.get()),
                        invoiceMapper.toInvoiceDto(exxInvoice.get()),
                        adminStaffMapper.toAdminStaffDto(exxAdminStaff.get())
                );
                paymentRepo.save(paymentMapper.dtoToPaymentEntity(paymentDto));
                return new CommonResponseDto(201, "payment  saved!", paymentDto.getPaymentId(), new ArrayList<>());
            } catch (Exception e) {
                throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
            }
        } else {
            throw new EntryNotFoundException("Can't Save because of this invoice or this admin staff not exists ");
        }
    }
}
