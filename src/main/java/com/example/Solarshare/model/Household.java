package com.example.Solarshare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "household")
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double allocationRatio;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAllocationRatio() {
        return allocationRatio;
    }

    public void setAllocationRatio(double allocationRatio) {
        this.allocationRatio = allocationRatio;
    }

    public Installation getInstallation() {
        return installation;
    }

    public void setInstallation(Installation installation) {
        this.installation = installation;
    }
}