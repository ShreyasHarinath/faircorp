package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoomDaoCustomImpl implements RoomDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findRoomByName(String name){
        String jpql = "SELECT r FROM Room r WHERE r.name = :name";
        return em.createQuery(jpql, Room.class).setParameter("name", name).getResultList();
    }
}