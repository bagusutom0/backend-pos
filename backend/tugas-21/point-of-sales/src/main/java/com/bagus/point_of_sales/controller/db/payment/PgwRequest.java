package com.bagus.point_of_sales.controller.db.payment;

import com.bagus.point_of_sales.model.transaction.PaymentMethod;
import lombok.Data;

@Data
public class PgwRequest {
    private String pgwName;
    private String merchantUcode;
    private String token;
    private String method;
}
