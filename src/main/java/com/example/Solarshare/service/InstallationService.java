package com.example.Solarshare.service;

import com.example.Solarshare.model.Installation;
import com.example.Solarshare.repository.InstallationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallationService {

    private final InstallationRepository installationRepository;

    public InstallationService(InstallationRepository installationRepository) {
        this.installationRepository = installationRepository;
    }

    public Installation createInstallation(Installation installation) {
        return installationRepository.save(installation);
    }

    public List<Installation> getAllInstallations() {
        return installationRepository.findAll();
    }

    public Installation getInstallationById(Long id) {
        return installationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Installation not found"));
    }

    public void deleteInstallation(Long id) {
        installationRepository.deleteById(id);
    }
}