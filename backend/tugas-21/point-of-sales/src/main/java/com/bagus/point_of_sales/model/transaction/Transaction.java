package com.bagus.point_of_sales.model.transaction;

import com.bagus.point_of_sales.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionProduct> transactionProducts;

    private Long amount;
    private Boolean isPaid;
    private PaymentMethod paymentMethod;
    private String vaNumber;
    private LocalDateTime createdAt;
    private LocalDateTime paymentDate;
}
