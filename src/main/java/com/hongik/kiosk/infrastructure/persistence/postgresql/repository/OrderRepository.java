package com.hongik.kiosk.infrastructure.persistence.postgresql.repository;

import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
