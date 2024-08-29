package com.vedha.entity.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Embeddable // This annotation is used to specify that the class is an embed
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderId {

    @GeneratedValue
    private Integer orderId;

    @Builder.Default
    private LocalDateTime orderDateTime = LocalDateTime.now();
}
