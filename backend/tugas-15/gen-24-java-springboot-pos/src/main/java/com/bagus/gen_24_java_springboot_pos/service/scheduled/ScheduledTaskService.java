package com.bagus.gen_24_java_springboot_pos.service.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduledTaskService {
    @Scheduled(cron = "0 0 9 * * MON-FRI")
    public void sarapan() {
        System.out.println("Pukul 9 waktu sarapan!!");
    }

    @Scheduled(cron = "0 0 15 * * MON-FRI")
    public void makanSore() {
        System.out.println("Pukul 15 waktu makan sore!!");
    }
}
