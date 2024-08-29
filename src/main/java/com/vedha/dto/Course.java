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
        name = "Course",
        description = "Course details"
)
public class Course {

    @Schema(
            name = "id",
            description = "Course ID",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            name = "title",
            description = "Course title",
            example = "Java Programming"
    )
    private String title;

    @Schema(
            name = "description",
            description = "Course description",
            example = "Learn Java Programming"
    )
    private String description;

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
            name = "sections",
            description = "Course sections",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Set<Section> sections;
}
