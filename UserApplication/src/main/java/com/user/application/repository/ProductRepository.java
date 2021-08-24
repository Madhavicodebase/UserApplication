package com.user.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.application.entity.ProductDetails;

public interface ProductRepository extends JpaRepository<ProductDetails,Integer> {
}
