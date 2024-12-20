package com.bagus.point_of_sales.controller.db.cart.request;

import lombok.Data;

@Data
public class DeleteProductRequest {
    private Long cartId;
    private Long cartProductId;
}