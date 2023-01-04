package com.emse.spring.faircorp.model;

import javax.persistence.*;

/**
 * This is Window Entity 
 * @Table Table name is `RWINDOW`
 * @Entity This is the entity name & is used to refer to the entity in queries.
 @author: Shreyas Harinath
*/

@Entity
@Table(name = "RWINDOW")
public class Window {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WindowStatus windowStatus;
    @ManyToOne
    private Room room;

    public Window() {
    }

    public Window(WindowStatus status, String name, Room room) {
        this.windowStatus = status;
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
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WindowStatus getWindowStatus() {
        return this.windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}