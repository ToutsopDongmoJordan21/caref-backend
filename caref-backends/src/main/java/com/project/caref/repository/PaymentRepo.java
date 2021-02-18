package com.project.caref.repository;

import com.project.caref.models.Payment;
import com.project.caref.models.PaymentDetail;
import com.project.caref.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    Payment findByTxnId(String txnId);

    List<Payment> findAllByUser(User user);
}
