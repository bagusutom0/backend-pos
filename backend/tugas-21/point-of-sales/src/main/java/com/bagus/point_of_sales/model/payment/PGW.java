package com.bagus.point_of_sales.model.payment;

import com.bagus.point_of_sales.model.transaction.PaymentMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.convert.DataSizeUnit;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PGW {
    @Id
    @GeneratedValue
    private Long id;
    private String pgwName;
    private String ucode;
    private String token;
    private PaymentMethod method;
}
