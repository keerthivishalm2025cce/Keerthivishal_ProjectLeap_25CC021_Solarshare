package com.example.Solarshare.repository;

import com.example.Solarshare.model.GenerationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenerationLogRepository extends JpaRepository<GenerationLog, Long> {
}