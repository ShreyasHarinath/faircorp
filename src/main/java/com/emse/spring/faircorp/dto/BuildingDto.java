package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.BuildingStatus;

public class BuildingDto {
    private Long id;
    private String name;
    private Double outTemperature;
    private BuildingStatus buildingStatus;

    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.outTemperature = building.getOutTemperature();
        this.buildingStatus = building.getBuildingStatus();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOutTemperature(Double outTemperature) {
        this.outTemperature = outTemperature;
    }

    public Double getOutTemperature() {
        return outTemperature;
    }

    public void setBuildingStatus(BuildingStatus status) {
        this.buildingStatus = status;
    }

    public BuildingStatus getBuildingStatus() {
        return this.buildingStatus;
    }
}