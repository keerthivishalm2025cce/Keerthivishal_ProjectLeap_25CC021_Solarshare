package com.example.Solarshare.Controller;

import com.example.Solarshare.Entity.Installation;
import com.example.Solarshare.Service.InstallationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/installations")
public class InstallationController {

    private final InstallationService installationService;

    public InstallationController(InstallationService installationService) {
        this.installationService = installationService;
    }

    @PostMapping
    public Installation createInstallation(@RequestBody Installation installation) {
        return installationService.createInstallation(installation);
    }

    @GetMapping
    public List<Installation> getAllInstallations() {
        return installationService.getAllInstallations();
    }

    @GetMapping("/{id}")
    public Installation getInstallationById(@PathVariable Long id) {
        return installationService.getInstallationById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteInstallation(@PathVariable Long id) {
        installationService.deleteInstallation(id);
        return "Installation deleted successfully";
    }
}