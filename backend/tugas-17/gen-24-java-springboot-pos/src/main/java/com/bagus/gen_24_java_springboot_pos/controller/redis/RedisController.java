package com.bagus.gen_24_java_springboot_pos.controller.redis;

import com.bagus.gen_24_java_springboot_pos.service.redis.RedisService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisController {
    private final RedisService service;

    @GetMapping("/saveredis")
    public ResponseEntity<String> get(
            @PathParam("key") String key,
            @PathParam("value") String value
    ) {
        service.save(key, value);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/getredis")
    public ResponseEntity<String> save(@PathParam("key") String key) {
        return ResponseEntity.ok(service.get(key));
    }
}
