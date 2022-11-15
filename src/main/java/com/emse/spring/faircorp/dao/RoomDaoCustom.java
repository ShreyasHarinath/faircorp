package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import java.util.List;

public interface RoomDaoCustom {
    List<Room> findRoomByName(String name);
}