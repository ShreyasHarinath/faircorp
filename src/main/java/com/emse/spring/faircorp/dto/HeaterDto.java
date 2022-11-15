package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;

public class HeaterDto {
    private Long id;
    private HeaterStatus heaterStatus;
    private String name;
    private Long power;
    private Long roomId;

    public HeaterDto() {
    }

    public HeaterDto(Heater heater) {
        this.id = heater.getId();
        this.name = heater.getName();
        this.power = heater.getPower();
        this.heaterStatus = heater.getHeaterStatus();
        this.roomId = heater.getRoom().getId();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Long getPower() {
        return power;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getRoomId() {
        return roomId;
    }
}