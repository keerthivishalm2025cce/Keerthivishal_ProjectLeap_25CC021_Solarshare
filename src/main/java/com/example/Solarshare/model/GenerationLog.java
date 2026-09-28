package com.example.Solarshare.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "generation_log")
public class GenerationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private double unitsGenerated;

    @ManyToOne
    @JoinColumn(name = "installation_id")
    private Installation installation;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getUnitsGenerated() {
        return unitsGenerated;
    }

    public void setUnitsGenerated(double unitsGenerated) {
        this.unitsGenerated = unitsGenerated;
    }

    public Installation getInstallation() {
        return installation;
    }

    public void setInstallation(Installation installation) {
        this.installation = installation;
    }
}