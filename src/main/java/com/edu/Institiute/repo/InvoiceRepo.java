package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface InvoiceRepo extends JpaRepository<Invoice,String> {
    @Query(value = "SELECT * FROM invoice WHERE invoice_id=:invoiceId", nativeQuery = true)
    Invoice findByInvoiceId(@Param("invoiceId") String invoiceId);

    @Query(value = "SELECT * FROM invoice WHERE invoice_id=:invoiceCode", nativeQuery = true)
    List<Invoice> getAllInvoiceForProvidedId(@Param("invoiceCode") String invoiceCode);

    @Query(value = "SELECT * FROM invoice WHERE invoice_id=:invoiceId", nativeQuery = true)
    Optional<Invoice> getInvoiceById(@Param("invoiceId")String invoiceId);
}
