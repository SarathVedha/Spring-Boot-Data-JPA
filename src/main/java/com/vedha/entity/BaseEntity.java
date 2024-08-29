package com.vedha.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Column(
            name = "creation_date",
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(
            name = "last_updated_date",
            insertable = false
    )
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;
}
