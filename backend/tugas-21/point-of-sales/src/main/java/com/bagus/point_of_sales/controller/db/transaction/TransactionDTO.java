package com.bagus.point_of_sales.controller.db.transaction;

import com.bagus.point_of_sales.controller.db.product.ProductDTO;
import com.bagus.point_of_sales.model.transaction.Transaction;
import com.bagus.point_of_sales.model.transaction.TransactionProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Long id;
    private List<TransactionProductDTO> transactionProducts;
    private Long totalAmount;
    private Long totalPay;
    private String createdAt;

    @Data
    public static class TransactionProductDTO {
        private Long id;
        private ProductDTO product;
        private int quantity;
        private Long subtotal;

        public TransactionProductDTO(TransactionProduct transactionProduct) {
            this.id = transactionProduct.getId();
            this.product = new ProductDTO(transactionProduct.getProduct());
            this.quantity = transactionProduct.getQuantity();
            this.subtotal = transactionProduct.getSubtotal();
        }
    }

    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.transactionProducts = transaction.getTransactionProducts()
                .stream()
                .map(TransactionProductDTO::new)
                .collect(Collectors.toList());
        this.totalAmount = transaction.getTotalAmount();
        this.totalPay = transaction.getTotalPay();
        this.createdAt = transaction.getCreatedAt();
    }
}
