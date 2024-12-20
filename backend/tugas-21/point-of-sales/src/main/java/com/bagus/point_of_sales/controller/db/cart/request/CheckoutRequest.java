package com.bagus.point_of_sales.controller.db.cart.request;

import lombok.Data;

@Data
public class CheckoutRequest {
    private Long cartId;
    private String paymentMethod;
}
