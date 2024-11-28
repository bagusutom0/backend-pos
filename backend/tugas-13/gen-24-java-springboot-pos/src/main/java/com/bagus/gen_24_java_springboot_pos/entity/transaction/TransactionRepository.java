package com.bagus.gen_24_java_springboot_pos.entity.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {
    @Query("SELECT t FROM Transaction t")
    List<Transaction> findAllTransactionJpql();

    @Query(value = "SELECT * FROM transaction", nativeQuery = true)
    List<Transaction> findAllTransactionNative();
}
