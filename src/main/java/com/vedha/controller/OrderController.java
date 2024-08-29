package com.vedha.controller;

import com.vedha.dto.Order;
import com.vedha.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Tag(
        name = "Order Controller",
        description = "This controller is responsible for handling order related operations"
)
public class OrderController {

    private final OrderService orderService;

    @Operation(
            summary = "Place Order",
            description = "Place Order"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PostMapping(value = "/place", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {

        return ResponseEntity.ok(orderService.placeOrder(order));
    }
}
