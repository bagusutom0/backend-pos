package com.bagus.gen_24_java_springboot_pos.entity.audit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@Builder
public class CekOngkirLog {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String origin;
    private String destination;
    private int weight;
    private String courier;
    private LocalDateTime timestamp;
}
