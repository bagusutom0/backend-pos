package com.bagus.gen_24_java_springboot_pos.service.api;

import com.bagus.gen_24_java_springboot_pos.entity.api.RajaOngkirResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import io.github.cdimascio.dotenv.Dotenv;

@Service
@RequiredArgsConstructor
public class RajaOngkirService {
    private final WebClient webClient;

    private final String API_KEY = Dotenv.load().get("API_KEY");

    public RajaOngkirResponse getShippingCost(String origin, String destination, int weight, String courier) {
        return webClient.post()
                .uri("/cost")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("key", API_KEY)
                .bodyValue(String.format("origin=%s&destination=%s&weight=%d&courier=%s",
                        origin, destination, weight, courier))
                .retrieve()
                .bodyToMono(RajaOngkirResponse.class)
                .block();
    }
}
