package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface HeaterDao extends JpaRepository<Heater, Long> {
    Heater getReferenceById(Long id);
    @Modifying
    void deleteByRoom(Long Id);
}