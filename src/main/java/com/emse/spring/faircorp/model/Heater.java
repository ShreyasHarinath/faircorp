package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "HEATER")
public class Heater {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private Long power;

    @ManyToOne(optional = false)
    private Room room;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HeaterStatus heaterStatus;

    public Heater() {

    }

    public Heater(HeaterStatus heaterStatus, String name, Long power, Room room) {
        this.heaterStatus = heaterStatus;
        this.name = name;
        this.power = power;
        this.room = room;
    }

    public Heater(HeaterStatus heaterStatus, String name, Room room) {
        this.heaterStatus = heaterStatus;
        this.name = name;
        this.room = room;
    }

    public Long getId() {
        return this.id;
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

    public Long getPower() {
        if (power == null){
            return 0L;
        } else {
            return power;
        }
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

}