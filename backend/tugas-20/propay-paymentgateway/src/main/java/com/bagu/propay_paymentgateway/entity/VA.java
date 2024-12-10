package com.bagu.propay_paymentgateway.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VA {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer merchantId;
    private String vaNumber;
    private Double amount;
    private LocalDateTime paymentDate;
    private String paymentCallBackUri;
    private LocalDateTime createdDate;
}
