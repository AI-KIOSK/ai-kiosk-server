package com.hongik.kiosk.infrastructure.persistence.postgresql.repository;

import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

    Optional<MenuEntity> findByName(String name);
}
