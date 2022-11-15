package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class HeaterDaoTest {
    @Autowired
    private HeaterDao heaterDao;
    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindAHeater() {
        Heater heater = heaterDao.getReferenceById(-10L);
        Assertions.assertThat(heater.getId()).isEqualTo(-10L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater1");
        Assertions.assertThat(heater.getPower()).isEqualTo(2000L);
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.ON);
        Assertions.assertThat(heater.getRoom().getId()).isEqualTo(-10L);
    }

    @Test
    public void shouldDeleteHeaterInRoom() {
        Room room = roomDao.getReferenceById(-10L);
        List<Long> heaterIds = room.getHeaters().stream().map(Heater::getId).collect(Collectors.toList());
        Assertions.assertThat(heaterIds.size()).isEqualTo(2);
        heaterDao.deleteByRoom(-10L);
        List<Heater> result = heaterDao.findAllById(heaterIds);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void ShouldCreateHeater() {
        Room room = roomDao.getReferenceById(-10l);
        Heater newHeater = new Heater();
        newHeater.setName("Test");
        newHeater.setPower(1750L);
        newHeater.setHeaterStatus(HeaterStatus.ON);
        newHeater.setRoom(room);
        Heater heater = heaterDao.save(newHeater);
        Assertions.assertThat(heater.getName()).isEqualTo(newHeater.getName());
        Assertions.assertThat(heater.getPower()).isEqualTo(newHeater.getPower());
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(newHeater.getHeaterStatus());
        Assertions.assertThat(heater.getRoom()).isEqualTo(newHeater.getRoom());
    }
}