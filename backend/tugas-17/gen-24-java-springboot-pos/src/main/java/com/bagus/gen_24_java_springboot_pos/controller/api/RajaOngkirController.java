package com.bagus.gen_24_java_springboot_pos.controller.api;

import com.bagus.gen_24_java_springboot_pos.entity.api.RajaOngkirResponse;
import com.bagus.gen_24_java_springboot_pos.service.api.RajaOngkirService;
import com.bagus.gen_24_java_springboot_pos.service.audit.CekOngkirLogService;
import com.bagus.gen_24_java_springboot_pos.service.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ongkir")
@RequiredArgsConstructor
public class RajaOngkirController {
    private final RajaOngkirService apiService;
    private final CekOngkirLogService logService;

    @GetMapping
    public ResponseEntity<RajaOngkirResponse> getShippingCost(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam int weight,
            @RequestParam String courier,
            @RequestHeader("Authorization") String authHeader
    ) throws InterruptedException {
        logService.saveLog(authHeader, origin, destination, weight, courier);
        return ResponseEntity.ok(apiService.getShippingCost(origin, destination, weight, courier));
    }
}
