package com.example.Solarshare.service;

import com.example.Solarshare.model.GenerationLog;
import com.example.Solarshare.model.Installation;
import com.example.Solarshare.repository.GenerationLogRepository;
import com.example.Solarshare.repository.InstallationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerationLogService {

    private final GenerationLogRepository generationLogRepository;
    private final InstallationRepository installationRepository;

    public GenerationLogService(GenerationLogRepository generationLogRepository,
                                InstallationRepository installationRepository) {
        this.generationLogRepository = generationLogRepository;
        this.installationRepository = installationRepository;
    }

    public GenerationLog createGenerationLog(Long installationId,
                                             GenerationLog generationLog) {

        if (generationLog.getUnitsGenerated() <= 0) {
            throw new RuntimeException("Generated units must be greater than 0");
        }

        if (generationLog.getDate() == null) {
            throw new RuntimeException("Generation date is required");
        }

        Installation installation = installationRepository.findById(installationId)
                .orElseThrow(() -> new RuntimeException("Installation not found"));

        generationLog.setInstallation(installation);

        return generationLogRepository.save(generationLog);
    }

    public List<GenerationLog> getAllGenerationLogs() {
        return generationLogRepository.findAll();
    }

    public GenerationLog getGenerationLogById(Long id) {
        return generationLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Generation log not found"));
    }

    public void deleteGenerationLog(Long id) {
        generationLogRepository.deleteById(id);
    }
}