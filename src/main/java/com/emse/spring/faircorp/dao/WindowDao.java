package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WindowDao extends JpaRepository<Window, Long>, WindowDaoCustom {
    Window getReferenceById(Long id);
    @Modifying
    void deleteByRoom(Long id);
}