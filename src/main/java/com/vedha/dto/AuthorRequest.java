package com.vedha.dto;

import com.vedha.util.Country;
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
        name = "AuthorRequest",
        description = "Author Request Details"
)
public class AuthorRequest {

    @Schema(
            name = "authorName",
            description = "Name of the author",
            example = "Vedha"
    )
    private String authorName;

    @Schema(
            name = "authorEmail",
            description = "Email of the author",
            example = "vedha@gmail.com"
    )
    private String authorEmail;

    @Schema(
            name = "authorCountry",
            description = "Country of the author",
            example = "IND"
    )
    private Country authorCountry;

    @Schema(
            name = "authorAge",
            description = "Age of the author",
            example = "25"
    )
    private Integer authorAge;

    @Schema(
            name = "courseTitle",
            description = "Course title",
            example = "Java Programming"
    )
    private String courseTitle;

    @Schema(
            name = "courseDescription",
            description = "Course description",
            example = "Learn Java Programming"
    )
    private String courseDescription;

    @Schema(
            name = "sectionName",
            description = "Section name",
            example = "Introduction to Java Programming"
    )
    private String sectionName;

    @Schema(
            name = "sectionOrder",
            description = "Section order",
            example = "1"
    )
    private Integer sectionOrder;

    @Schema(
            name = "lectureName",
            description = "Lecture Name",
            example = "Java Programming"
    )
    private String lectureName;

    @Schema(
            name = "resourceName",
            description = "Resource Name",
            example = "PDF"
    )
    private String resourceName;

    @Schema(
            name = "resourceSize",
            description = "Resource Size",
            example = "1000"
    )
    private Integer resourceSize;

    @Schema(
            name = "resourceUrl",
            description = "Resource URL",
            example = "https://www.example.com/resource"
    )
    private String resourceUrl;
}
