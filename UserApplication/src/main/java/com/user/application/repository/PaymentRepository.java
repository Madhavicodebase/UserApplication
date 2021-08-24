package com.user.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.application.entity.PaymentMethod;

public interface PaymentRepository extends JpaRepository<PaymentMethod,Integer> {
}
