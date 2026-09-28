package com.example.Solarshare.controller;

import com.example.Solarshare.model.Household;
import com.example.Solarshare.service.HouseholdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {
    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping("/installation/{installationId}")
    public Household createHousehold(
            @PathVariable Long installationId,
            @RequestBody Household household) {

        return householdService.createHousehold(
                installationId,
                household
        );
    }
}
