package com.hongik.kiosk.infrastructure.persistence.postgresql.repository;

import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
