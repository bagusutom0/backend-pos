package com.bagus.gen_24_java_springboot_pos.entity.transaction;

import org.springframework.data.jpa.domain.Specification;

public class TransactionSpecifications {
    public static Specification<Transaction> hasQuantityMoreThanOrEqual(int quantity) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("quantity"), quantity);
    }
}
