package com.bagus.gen_24_java_springboot_pos.entity.transaction;

import com.bagus.gen_24_java_springboot_pos.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "transaction_seq",
            sequenceName = "transaction_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_seq"
    )
    private Long transaction_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    private int total_price;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime transaction_date;
}
