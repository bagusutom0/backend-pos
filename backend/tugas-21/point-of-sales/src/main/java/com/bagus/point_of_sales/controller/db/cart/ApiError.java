package com.bagus.point_of_sales.controller.db.cart;

import lombok.Data;

@Data
public class ApiError {
    private String message;

    public ApiError(String message) {
        this.message = message;
    }
}
