package com.bagus.point_of_sales.controller.db.transaction;

import com.bagus.point_of_sales.controller.db.product.ProductDTO;
import com.bagus.point_of_sales.model.product.Product;
import com.bagus.point_of_sales.model.transaction.TransactionProduct;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    private Long totalAmount;
    private Long totalPay;
    private List<OrderProduct> orderProducts;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderProduct {
        private ProductDTO product;
        private int quantity;
        private Long subtotal;

        public OrderProduct(TransactionProduct transactionProduct) {
            this.product = new ProductDTO(transactionProduct.getProduct());
            this.quantity = transactionProduct.getQuantity();
            this.subtotal = transactionProduct.getSubtotal();
        }
    }
}
