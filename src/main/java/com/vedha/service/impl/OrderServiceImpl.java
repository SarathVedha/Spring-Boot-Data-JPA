package com.vedha.service.impl;

import com.vedha.dto.Order;
import com.vedha.entity.embedded.OrderEntity;
import com.vedha.repository.embedded.OrderRepository;
import com.vedha.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ModelMapper modelMapper;

    private final OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order) {

        OrderEntity orderEntity = OrderEntity.builder()
                .orderName(order.getOrderName())
                .address(order.getAddress())
                .orderDescription(order.getOrderDescription())
                .build();

        OrderEntity save = orderRepository.save(orderEntity);

        return modelMapper.map(save, Order.class);
    }
}
