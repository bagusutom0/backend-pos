package com.bagus.gen_24_java_springboot_pos.entity.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CekOngkirLogRepository extends JpaRepository<CekOngkirLog, Long> {
}
