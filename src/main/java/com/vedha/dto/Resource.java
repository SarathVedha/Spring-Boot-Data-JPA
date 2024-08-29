package com.vedha.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Resource",
        description = "Resource Details"
)
public class Resource {

    @Schema(
            name = "id",
            description = "Resource ID",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            name = "name",
            description = "Resource Name",
            example = "Resource Name"
    )
    private String name;

    @Schema(
            name = "size",
            description = "Resource Size",
            example = "1000"
    )
    private Integer size;

    @Schema(
            name = "url",
            description = "Resource URL",
            example = "https://www.example.com/resource"
    )
    private String url;
}
