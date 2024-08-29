package com.vedha.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resources")
@RequiredArgsConstructor
@Tag(
        name = "Resource Controller",
        description = "This controller is responsible for handling resource related operations"
)
public class ResourceController {

}
