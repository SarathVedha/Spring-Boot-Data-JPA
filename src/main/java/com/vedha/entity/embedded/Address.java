package com.vedha.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@Embeddable // This annotation is used to specify that the class is an embed
@AllArgsConstructor
@RequiredArgsConstructor
public class Address {

    private String street;

    private String city;

    private String state;

    private Integer zipCode;
}
