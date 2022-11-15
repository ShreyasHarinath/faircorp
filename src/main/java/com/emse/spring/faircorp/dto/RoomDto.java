package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Room;

public class RoomDto {
    private Long id;
    private String name;
    private Integer floor;
    private Double currentTemperature;
    private Double targetTemperature;
    private Long buildingId;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        this.buildingId = room.getBuilding().getId();
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

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void SetBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getBuildingId() {
        return this.buildingId;
    }
}