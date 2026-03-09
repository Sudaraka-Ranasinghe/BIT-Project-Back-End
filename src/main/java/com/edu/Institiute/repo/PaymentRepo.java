package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,String> {

    @Query(value = "SELECT * FROM payment WHERE payment_id=:paymentId", nativeQuery = true)
    Payment findByPaymentId(@Param("paymentId") String paymentId);

    @Query(value = "SELECT * FROM payment WHERE payment_id=:paymentId", nativeQuery = true)
    List<Payment> getAllPaymentForProvidedId(@Param("paymentId") String paymentId);

    @Query(value = "SELECT * FROM payment WHERE payment_id=:paymentId", nativeQuery = true)
    Optional<Payment> getPaymentById(@Param("paymentId")String paymentId);

}
