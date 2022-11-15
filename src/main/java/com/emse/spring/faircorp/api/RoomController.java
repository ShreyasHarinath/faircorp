package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {
    private final RoomDao roomDao;
    private final BuildingDao buildingDao;

    public RoomController(RoomDao roomDao, BuildingDao buildingDao) {
        this.roomDao = roomDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        Building building = buildingDao.getReferenceById(dto.getBuildingId());
        Room room = null;
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getName(), dto.getFloor(), dto.getCurrentTemperature(), dto.getTargetTemperature(), building));
        } else {
            room = roomDao.getReferenceById(dto.getId());
        }
        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/switch-window")
    public List<WindowDto> switchWindow(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        Set<Window> windows = (Set<Window>) room.getWindows();
        List<WindowDto> result = new ArrayList<>();
        for (Window window : windows) {
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN);
            result.add(new WindowDto(window));
        }
        return result;
    }

    @PutMapping(path = "/{id}/switch-heater")
    public List<HeaterDto> switchHeater(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        Set<Heater> heaters = (Set<Heater>) room.getHeaters();
        List<HeaterDto> result = new ArrayList<>();
        for (Heater heater : heaters) {
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);
            result.add(new HeaterDto(heater));
        }
        return result;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }
}