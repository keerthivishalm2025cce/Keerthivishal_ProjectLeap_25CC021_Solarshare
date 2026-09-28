package com.example.Solarshare.repository;

import com.example.Solarshare.model.ConsumptionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumptionLogRepository extends JpaRepository<ConsumptionLog, Long> {
}