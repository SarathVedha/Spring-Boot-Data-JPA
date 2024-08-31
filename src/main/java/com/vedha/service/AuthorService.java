package com.vedha.service;

import com.vedha.dto.Author;
import com.vedha.dto.AuthorRequest;
import com.vedha.dto.AuthorResponse;
import com.vedha.util.Country;

import java.util.List;
import java.util.Map;

public interface AuthorService {

    AuthorResponse saveAuthor(Author author);

    AuthorResponse saveNewAuthor(AuthorRequest authorRequest);

    List<Author> getAuthors();

    Author getAuthorById(Long id);

    List<Author> getAuthorsByName(String firstName);

    Map<String, String> countOfAuthorsByAge(int age);

    Map<String, String> deleteAuthorsByAge(int age);

    Map<String, String> deleteAuthorsByEmailLikes(String email);

    List<Author> getAuthorsByAgeLessThanEqual(int age);

    List<Author> getAuthorsByNameAndAgeGreaterThanEqual(String name, int age);

    List<Author> getAuthorsByNameStartingWith(String name);

    List<Author> getAuthorsByEmailIn(List<String> names);

    Map<String, String> countOfAuthorsBeforeCreatedDate();

    List<AuthorResponse> addFakeAuthors(int count);

    AuthorResponse updateAuthorById(Long id, Author authorRequest);

    Map<String, String> updateAuthorNameByEmail(String name, String email);

    List<Author> getAuthorsByCountry(Country country);

    Map<String, String> updateAuthorByCountryById(Country country, Long id);

    Map<String, String> deleteAuthorsByCountry(Country country);

    Map<String, String> deleteAuthorsByAgeGreaterThan(int age);

    List<Author> getAuthorByNameLikeAndNotLikeAndAgeGreaterThanEqual(String likeName, String notLikeName, int age);

    Map<String, String> getValueFromProcedure(String value);
}
