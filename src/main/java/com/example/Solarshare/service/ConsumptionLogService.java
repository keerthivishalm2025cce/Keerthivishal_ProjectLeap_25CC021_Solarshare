package com.example.Solarshare.service;

import com.example.Solarshare.model.ConsumptionLog;
import com.example.Solarshare.model.Household;
import com.example.Solarshare.repository.ConsumptionLogRepository;
import com.example.Solarshare.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionLogService {

    private final ConsumptionLogRepository consumptionLogRepository;
    private final HouseholdRepository householdRepository;

    public ConsumptionLogService(ConsumptionLogRepository consumptionLogRepository,
                                 HouseholdRepository householdRepository) {
        this.consumptionLogRepository = consumptionLogRepository;
        this.householdRepository = householdRepository;
    }

    public ConsumptionLog createConsumptionLog(Long householdId,
                                               ConsumptionLog consumptionLog) {

        if (consumptionLog.getUnitsConsumed() < 0) {
            throw new RuntimeException("Consumed units cannot be negative");
        }

        if (consumptionLog.getDate() == null) {
            throw new RuntimeException("Consumption date is required");
        }

        Household household = householdRepository.findById(householdId)
                .orElseThrow(() -> new RuntimeException("Household not found"));

        consumptionLog.setHousehold(household);

        return consumptionLogRepository.save(consumptionLog);
    }

    public List<ConsumptionLog> getAllConsumptionLogs() {
        return consumptionLogRepository.findAll();
    }

    public ConsumptionLog getConsumptionLogById(Long id) {
        return consumptionLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumption log not found"));
    }

    public void deleteConsumptionLog(Long id) {
        consumptionLogRepository.deleteById(id);
    }
}