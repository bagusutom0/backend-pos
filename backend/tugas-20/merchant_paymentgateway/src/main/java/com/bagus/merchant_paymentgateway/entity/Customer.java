package com.bagus.merchant_paymentgateway.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
