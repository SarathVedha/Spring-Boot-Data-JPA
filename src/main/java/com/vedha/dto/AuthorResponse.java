package com.vedha.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vedha.util.Country;
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
        name = "AuthorResponse",
        description = "Author response"
)
public class AuthorResponse {

    @Schema(
            name = "id",
            description = "Unique identifier of the author",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            name = "name",
            description = "Name of the author",
            example = "Vedha"
    )
    private String name;

    @Schema(
            name = "email",
            description = "Email of the author",
            example = "vedha@gmail.com"
    )
    private String email;

    @Schema(
            name = "country",
            description = "Country of the author",
            example = "IND"
    )
    private Country country;

    @Schema(
            name = "age",
            description = "Age of the author",
            example = "25"
    )
    private Integer age;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @Schema(
            name = "creationDate",
            description = "Created date of the author",
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
            description = "Updated date of the author",
            example = "2021-07-01 12:00:00",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private LocalDateTime lastUpdateDate;
}
