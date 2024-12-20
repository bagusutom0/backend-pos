package com.bagus.point_of_sales.controller.db.transaction;

import com.bagus.point_of_sales.controller.db.cart.CartDTO;
import com.bagus.point_of_sales.model.product.Product;
import com.bagus.point_of_sales.model.transaction.PaymentMethod;
import com.bagus.point_of_sales.model.transaction.Transaction;
import com.bagus.point_of_sales.model.transaction.TransactionProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Long id;
    private CartDTO.UserDTO user;
    private List<TransactionProductDTO> transactionProducts;
    private Long amount;
    private Boolean isPaid;
    private PaymentMethod paymentMethod;
    private String vaNumber;
    private LocalDateTime paymentDate;
    private LocalDateTime createdAt;

    @Data
    public static class TransactionProductDTO {
        private Long id;
        private Product product;
        private int quantity;
        private Long price;

        public TransactionProductDTO(TransactionProduct transactionProduct) {
            this.id = transactionProduct.getId();
            this.product = transactionProduct.getProduct();
            this.quantity = transactionProduct.getQuantity();
            this.price = transactionProduct.getPrice();
        }
    }

    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.user = new CartDTO.UserDTO(transaction.getUser()); // Mapping User ke UserDTO
        this.transactionProducts = transaction.getTransactionProducts()
                .stream()
                .map(TransactionProductDTO::new)
                .collect(Collectors.toList());
        this.amount = transaction.getAmount();
        this.isPaid = transaction.getIsPaid();
        this.paymentMethod = transaction.getPaymentMethod();
        this.vaNumber = transaction.getVaNumber();
        this.paymentDate = transaction.getPaymentDate();
        this.createdAt = transaction.getCreatedAt();
    }
}
