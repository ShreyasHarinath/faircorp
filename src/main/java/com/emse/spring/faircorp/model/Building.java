package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BUILDING")
public class Building {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double outTemperature;

    @Column(nullable = false)
    @OneToMany(mappedBy = "building")
    private Set<Room> rooms;

    @Enumerated(EnumType.STRING)
    private BuildingStatus buildingStatus;

    public Building() {

    }

    public Building(String name, Double outTemperature, BuildingStatus buildingStatus) {
        this.name = name;
        this.outTemperature = outTemperature;
        this.buildingStatus = buildingStatus;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setOutTemperature(Double outTemperature) {
        this.outTemperature = outTemperature;
    }

    public Double getOutTemperature() {
        return this.outTemperature;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Room> getRooms() {
        return this.rooms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBuildingStatus(BuildingStatus status) {
        this.buildingStatus = status;
    }

    public BuildingStatus getBuildingStatus() {
        return this.buildingStatus;
    }
}