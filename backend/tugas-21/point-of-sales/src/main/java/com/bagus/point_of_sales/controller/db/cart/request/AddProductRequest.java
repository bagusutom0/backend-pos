package com.bagus.point_of_sales.controller.db.cart.request;

import lombok.Data;

@Data
public class AddProductRequest {
    private Long cartId;
    private Long productId;
    private int quantity;
}
