package com.vedha.controller;

import com.vedha.dto.Author;
import com.vedha.dto.AuthorRequest;
import com.vedha.dto.AuthorResponse;
import com.vedha.service.AuthorService;
import com.vedha.util.Country;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
@Tag(
        name = "Author Controller",
        description = "This controller is responsible for handling author related operations"
)
public class AuthorController {

    private final AuthorService authorService;

    @Operation(
            summary = "Create Author",
            description = "Create Author"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorResponse> createNewAuthor(@RequestBody AuthorRequest authorRequest) {

        return ResponseEntity.ok(authorService.saveNewAuthor(authorRequest));
    }

    @Operation(
            summary = "Create Author Only",
            description = "Create Author Only"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PostMapping(value = "/createAuthor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody Author author) {

        return ResponseEntity.ok(authorService.saveAuthor(author));
    }

    @Operation(
            summary = "Get All Authors",
            description = "Get All Authors"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getAuthors() {

        return ResponseEntity.ok(authorService.getAuthors());
    }

    @Operation(
            summary = "Get Author By Id",
            description = "Get Author By Id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {

        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @Operation(
            summary = "Get Author By Name",
            description = "Get Author By Name"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping(value = "/get/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getAuthorByName(@RequestParam String name) {

        return ResponseEntity.ok(authorService.getAuthorsByName(name));
    }

    @Operation(
            summary = "Get Author By Age",
            description = "Get Author By Age"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping(value = "/get/count/age", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getAuthorCountByAge(@RequestParam int age) {

        return ResponseEntity.ok(authorService.countOfAuthorsByAge(age));
    }

    @Operation(
            summary = "Delete Author",
            description = "Delete Author"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @DeleteMapping(value = "/delete/age", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteAuthorByAge(@RequestParam int age) {

        return ResponseEntity.ok(authorService.deleteAuthorsByAge(age));
    }

    @Operation(
            summary = "Delete Author By Email",
            description = "Delete Author By Email"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @DeleteMapping(value = "/delete/email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteAuthorByEmail(@RequestParam String email) {

        return ResponseEntity.ok(authorService.deleteAuthorsByEmailLikes(email));
    }

    @Operation(
            summary = "Get Author By Age Less Than Equal",
            description = "Get Author By Age Less Than Equal"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping(value = "/get/age/less", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getAuthorsByAgeLessThanEqual(@RequestParam int age) {

        return ResponseEntity.ok(authorService.getAuthorsByAgeLessThanEqual(age));
    }

    @Operation(
            summary = "Get Author By Name And Age Greater Than Equal",
            description = "Get Author By Name And Age Greater Than Equal"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping(value = "/get/name/age", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getAuthorsByNameAndAgeGreaterThanEqual(@RequestParam String name, @RequestParam int age) {

        return ResponseEntity.ok(authorService.getAuthorsByNameAndAgeGreaterThanEqual(name, age));
    }

    @Operation(
            summary = "Get Author Count Before Created Date",
            description = "Get Author Count Before Created Date"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping(value = "/get/count/created", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getAuthorCountBeforeCreatedDate() {

        return ResponseEntity.ok(authorService.countOfAuthorsBeforeCreatedDate());
    }

    @Operation(
            summary = "Get Author By Name Starting With",
            description = "Get Author By Name Starting With"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping(value = "/get/name/start", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getAuthorsByNameStartingWith(@RequestParam String name) {

        return ResponseEntity.ok(authorService.getAuthorsByNameStartingWith(name));
    }

    @Operation(
            summary = "Get Author By Emails In",
            description = "Get Author By Emails In"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping(value = "/get/email/in", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getAuthorsByEmailIn(@RequestParam List<String> emails) {

        return ResponseEntity.ok(authorService.getAuthorsByEmailIn(emails));
    }

    @Operation(
            summary = "Add Fake Authors",
            description = "Add Fake Authors"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PostMapping(value = "/add/fake", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AuthorResponse>> addFakeAuthors(@RequestParam int count) {

        return ResponseEntity.ok(authorService.addFakeAuthors(count));
    }

    @Operation(
            summary = "Update Author By Id",
            description = "Update Author By Id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorResponse> updateAuthorById(@PathVariable Long id, @RequestBody Author authorRequest) {

        return ResponseEntity.ok(authorService.updateAuthorById(id, authorRequest));
    }

    @Operation(
            summary = "Update Author Name By Email",
            description = "Update Author Name By Email"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping(value = "/update/name/email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> updateAuthorNameByEmail(@RequestParam String name, @RequestParam String email) {

        return ResponseEntity.ok(authorService.updateAuthorNameByEmail(name, email));
    }

    @Operation(
            summary = "Delete Author By Age Greater Than",
            description = "Delete Author By Age Greater Than"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @DeleteMapping(value = "/delete/age/greater", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteAuthorsByAgeGreaterThan(@RequestParam int age) {

        return ResponseEntity.ok(authorService.deleteAuthorsByAgeGreaterThan(age));
    }

    @Operation(
            summary = "Get Author By Country",
            description = "Get Author By Country"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping(value = "/get/country", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getAuthorsByCountry(@RequestParam Country country) {

        return ResponseEntity.ok(authorService.getAuthorsByCountry(country));
    }

    @Operation(
            summary = "Update Author By Country And Id",
            description = "Update Author By Country And Id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping(value = "/update/country/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> updateAuthorByCountryById(@RequestParam Country country, @PathVariable Long id) {

        return ResponseEntity.ok(authorService.updateAuthorByCountryById(country, id));
    }

    @Operation(
            summary = "Delete Author By Country",
            description = "Delete Author By Country"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @DeleteMapping(value = "/delete/country", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteAuthorsByCountry(@RequestParam Country country) {

        return ResponseEntity.ok(authorService.deleteAuthorsByCountry(country));
    }

    @Operation(
            summary = "Get Author By Name Like And Not Like And Age Greater Than Equal",
            description = "Get Author By Name Like And Not Like And Age Greater Than Equal"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping(value = "/get/name/like/notLike", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getAuthorByNameLikeAndNotLikeAndAgeGreaterThanEqual(@RequestParam String likeName, @RequestParam String notLikeName, @RequestParam int age) {

        return ResponseEntity.ok(authorService.getAuthorByNameLikeAndNotLikeAndAgeGreaterThanEqual(likeName, notLikeName, age));
    }
}
