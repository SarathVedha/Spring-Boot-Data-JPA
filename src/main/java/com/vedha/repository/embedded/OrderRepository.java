package com.vedha.repository.embedded;

import com.vedha.entity.embedded.OrderEntity;
import com.vedha.entity.embedded.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, OrderId> {
}
