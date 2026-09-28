package com.example.Solarshare.service;

import com.example.Solarshare.model.Household;
import com.example.Solarshare.model.Installation;
import com.example.Solarshare.repository.HouseholdRepository;
import com.example.Solarshare.repository.InstallationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService {

    private final HouseholdRepository householdRepository;
    private final InstallationRepository installationRepository;

    public HouseholdService(HouseholdRepository householdRepository,
                            InstallationRepository installationRepository) {
        this.householdRepository = householdRepository;
        this.installationRepository = installationRepository;
    }

    public Household createHousehold(Long installationId, Household household) {

        if (household.getAllocationRatio() <= 0 ||
                household.getAllocationRatio() > 100) {
            throw new RuntimeException("Allocation ratio must be between 0 and 100");
        }

        Installation installation = installationRepository.findById(installationId)
                .orElseThrow(() -> new RuntimeException("Installation not found"));

        household.setInstallation(installation);

        return householdRepository.save(household);
    }

    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    public Household getHouseholdById(Long id) {
        return householdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Household not found"));
    }

    public void deleteHousehold(Long id) {
        householdRepository.deleteById(id);
    }
}