package com.vedha.dto;

import com.vedha.entity.embedded.Address;
import com.vedha.entity.embedded.OrderId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Schema(description = "Order Id", accessMode = Schema.AccessMode.READ_ONLY)
    private OrderId id;

    private String orderName;

    private Address address;

    private String orderDescription;
}
