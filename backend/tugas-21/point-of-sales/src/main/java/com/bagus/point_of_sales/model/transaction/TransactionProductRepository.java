package com.bagus.point_of_sales.model.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionProductRepository extends JpaRepository<TransactionProduct, Long> {
}
