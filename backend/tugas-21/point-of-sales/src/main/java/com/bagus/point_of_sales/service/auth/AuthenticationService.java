package com.bagus.point_of_sales.service.auth;

import com.bagus.point_of_sales.controller.auth.AuthenticationRequest;
import com.bagus.point_of_sales.controller.auth.AuthenticationDTO;
import com.bagus.point_of_sales.controller.auth.RegisterRequest;
import com.bagus.point_of_sales.model.user.Role;
import com.bagus.point_of_sales.model.user.User;
import com.bagus.point_of_sales.model.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthenticationDTO register(RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .role(Role.valueOf(request.getRole()))
                .build();
        User savedUser = repository.save(user);

        String token = jwtService.generateToken(
                Map.of("role", Role.valueOf(request.getRole())),
                user
        );
        return AuthenticationDTO.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .role(savedUser.getRole())
                .token(token)
                .build();
    }

    public AuthenticationDTO authenticate(AuthenticationRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        String token = jwtService.generateToken(user);
        return AuthenticationDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .role(user.getRole())
                .token(token)
                .build();
    }
}
