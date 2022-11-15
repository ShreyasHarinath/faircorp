package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RoomDaoTest {
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private BuildingDao buildingDao;

    @Test
    public void shouldFindARoom() {
        Room room = roomDao.getReferenceById(-10L);
        Assertions.assertThat(room.getId()).isEqualTo(-10L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
        Assertions.assertThat(room.getFloor()).isEqualTo(1);
        Assertions.assertThat(room.getCurrentTemperature()).isEqualTo(22.3);
        Assertions.assertThat(room.getTargetTemperature()).isEqualTo(20.0);
    }

    @Test
    public void shouldFindARoomByName() {
        List<Room> result = roomDao.findRoomByName("Room1");
        Assertions.assertThat(result).isNotEmpty();
    }

    @Test
    public void shouldNotFindARoomByName() {
        List<Room> result = roomDao.findRoomByName("NOTARoom1");
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void shouldCreateARoom() {
        Building building = buildingDao.getReferenceById(-10l);
        Room newRoom = new Room();
        newRoom.setName("Test");
        newRoom.setFloor(2);
        newRoom.setCurrentTemperature(14.0);
        newRoom.setTargetTemperature(28.0);
        newRoom.setBuilding(building);
        Room room = roomDao.save(newRoom);
        Assertions.assertThat(room.getName()).isEqualTo(newRoom.getName());
        Assertions.assertThat(room.getFloor()).isEqualTo(newRoom.getFloor());
        Assertions.assertThat(room.getCurrentTemperature()).isEqualTo(newRoom.getCurrentTemperature());
        Assertions.assertThat(room.getTargetTemperature()).isEqualTo(newRoom.getTargetTemperature());
        Assertions.assertThat(room.getBuilding()).isEqualTo(newRoom.getBuilding());
    }
}