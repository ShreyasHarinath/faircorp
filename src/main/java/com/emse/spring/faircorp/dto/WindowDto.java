package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

public class WindowDto {
    private Long id;
    private WindowStatus windowStatus;
    private String name;
    private String roomName;
    private Long roomId;

    public WindowDto() {
    }

    public WindowDto(Window window) {
        this.id = window.getId();
        this.windowStatus = window.getWindowStatus();
        this.name = window.getName();
        this.roomName = window.getRoom().getName();
        this.roomId = window.getRoom().getId();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getRoomId() {
        return roomId;
    }
}