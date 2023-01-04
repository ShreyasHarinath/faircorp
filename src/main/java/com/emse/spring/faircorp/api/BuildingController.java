package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dto.BuildingDto;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.*;

/**
 * This class is for defining Building controller logics
 @author: Shreyas Harinath
*/

@RestController
@RequestMapping("/api/building")
@Transactional
public class BuildingController {
    private final BuildingDao buildingDao;

    public BuildingController(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    /**
     * Gets all the building list
     * @return list of buildings
    */

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null);
    }

    @GetMapping(path = "/rooms/{id}")
    public List<RoomDto> getRooms(@PathVariable Long id){
        return  buildingDao.getRelatedRooms(id).stream().map(RoomDto::new).collect(Collectors.toList());
    }

    /**
     * Post request to create building or to update building
     * @param dto contains building name, status and outside temperature
     * @return new building if building id is not provided otherwise updates building with provided building id
    */

    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getName(), dto.getOutTemperature(), dto.getBuildingStatus()));
        } else {
            building = buildingDao.getReferenceById(dto.getId());
        }
        return new BuildingDto(building);
    }

    @PutMapping(path = "/{id}/switch")
    public BuildingDto switchStatus(@PathVariable Long id) {
        Building building = buildingDao.findById(id).orElseThrow(IllegalArgumentException::new);
        building.setBuildingStatus(building.getBuildingStatus() == BuildingStatus.LOCKED ? BuildingStatus.UNLOCKED : BuildingStatus.LOCKED);
        return new BuildingDto(building);
    }

    /**
     * Delete building deletes specific building with provided building id.
     * @param building_id building which needs to be deleted
    */

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        buildingDao.deleteById(id);
    }

}