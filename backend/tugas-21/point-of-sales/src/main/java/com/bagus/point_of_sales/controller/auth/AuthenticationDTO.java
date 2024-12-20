package com.bagus.point_of_sales.controller.auth;

import com.bagus.point_of_sales.model.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class AuthenticationDTO {
    private Long id;
    private String name;
    private Role role;
    private String token;
}