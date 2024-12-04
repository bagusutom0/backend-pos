package com.bagus.gen_24_java_springboot_pos.service.audit;

import com.bagus.gen_24_java_springboot_pos.entity.audit.CekOngkirLog;
import com.bagus.gen_24_java_springboot_pos.entity.audit.CekOngkirLogRepository;
import com.bagus.gen_24_java_springboot_pos.service.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CekOngkirLogService {

    private final CekOngkirLogRepository repository;
    private final JwtService jwtService;

    @Async
    public void saveLog(String header, String origin, String destination, int weight, String courier) throws InterruptedException {
        Thread.sleep(3000L); // simulasi async 3 detik

        String token = header.substring(7);
        String username = jwtService.extractUsername(token);

        CekOngkirLog audit = CekOngkirLog.builder()
                .username(username)
                .origin(origin)
                .destination(destination)
                .weight(weight)
                .courier(courier)
                .timestamp(LocalDateTime.now())
                .build();
        log.info("Cek Ongkir Log: " + audit);
        repository.save(audit);
    }
}
