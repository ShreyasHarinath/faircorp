package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private Double currentTemperature;

    @Column(nullable = true)
    private Double targetTemperature;

    @ManyToOne(optional = false)
    private Building building;

    @OneToMany(mappedBy = "room")
    private Set<Heater> heaters;

    @OneToMany(mappedBy = "room")
    private Set<Window> windows;

    public Room() {

    }

    public Room(String name, Integer floor, Double currentTemperature, Double targetTemperature, Building building) {
        this.name = name;
        this.floor = floor;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.building = building;
    }

    public Room(String name, Integer floor, Building building) {
        this.name = name;
        this.floor = floor;
        this.building = building;
    }

    public Room(String name, Integer floor) {
        this.name = name;
        this.floor = floor;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWindows(Set<Window> windows) {
        this.windows = windows;
    }

    public Set<Window> getWindows() {
        return windows;
    }

    public void setHeaters(Set<Heater> heaters) {
        this.heaters = heaters;
    }

    public Set<Heater> getHeaters() {
        return  heaters;
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

    public double getCurrentTemperature() {
        if(currentTemperature == null){
            return 0;
        } else {
            return currentTemperature;
        }
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double getTargetTemperature() {
        if(targetTemperature == null){
            return 0;
        } else {
            return targetTemperature;
        }
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Room(String rm) {
        this.name = rm;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }
}
