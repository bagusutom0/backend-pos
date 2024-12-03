package com.bagus.gen_24_java_springboot_pos.controller.api;

import com.bagus.gen_24_java_springboot_pos.entity.api.RajaOngkirResponse;
import com.bagus.gen_24_java_springboot_pos.service.api.RajaOngkirService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ongkir")
@RequiredArgsConstructor
public class RajaOngkirController {
    private final RajaOngkirService service;

    @GetMapping
    public ResponseEntity<RajaOngkirResponse> getShippingCost(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam int weight,
            @RequestParam String courier
    ) {
        return ResponseEntity.ok(service.getShippingCost(origin, destination, weight, courier));
    }
}
