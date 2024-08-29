package com.vedha.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Lecture",
        description = "Lecture Details"
)
public class Lecture {

    @Schema(
            name = "id",
            description = "Lecture ID",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            name = "name",
            description = "Lecture Name",
            example = "Lecture Name"
    )
    private String name;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @Schema(
            name = "creationDate",
            description = "Course creation date",
            example = "2021-07-01 12:00:00",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private LocalDateTime creationDate;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @Schema(
            name = "lastUpdateDate",
            description = "Course last update date",
            example = "2021-07-01 12:00:00",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private LocalDateTime lastUpdateDate;

    @Schema(
            name = "resource",
            description = "Resource Details"
    )
    private Resource resource;
}
