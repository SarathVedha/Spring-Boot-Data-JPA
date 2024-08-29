package com.vedha.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Section",
        description = "Section details"
)
public class Section {

    @Schema(
            name = "id",
            description = "Section ID",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            name = "name",
            description = "Section name",
            example = "Introduction to Java Programming"
    )
    private String name;

    @Schema(
            name = "order",
            description = "Section order",
            example = "1"
    )
    private Integer order;

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
            name = "lectures",
            description = "Lectures in the section",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Set<Lecture> lectures;
}
