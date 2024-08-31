package com.vedha.service.impl;

import com.github.javafaker.Faker;
import com.vedha.dto.Author;
import com.vedha.dto.AuthorRequest;
import com.vedha.dto.AuthorResponse;
import com.vedha.entity.*;
import com.vedha.repository.*;
import com.vedha.repository.specification.AuthorSpecification;
import com.vedha.service.AuthorService;
import com.vedha.util.Country;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final ModelMapper modelMapper;

    private final AuthorRepository authorRepository;

    private final CourseRepository courseRepository;

    private final SectionRepository sectionRepository;

    private final LectureRepository lectureRepository;

    private final VideoRepository videoRepository;

    @Override
    public AuthorResponse saveAuthor(Author author) {

        AuthorEntity map = modelMapper.map(author, AuthorEntity.class);
        AuthorEntity save = authorRepository.save(map);

        return modelMapper.map(save, AuthorResponse.class);
    }

    @Override
    @Transactional
    public AuthorResponse saveNewAuthor(AuthorRequest authorRequest) {

        AuthorEntity author = AuthorEntity.builder()
                .name(authorRequest.getAuthorName())
                .email(authorRequest.getAuthorEmail())
                .country(authorRequest.getAuthorCountry())
                .age(authorRequest.getAuthorAge())
                .build();
        authorRepository.save(author);

        CourseEntity course = CourseEntity.builder()
                .title(authorRequest.getCourseTitle())
                .description(authorRequest.getCourseDescription())
                .authors(Set.of(author))
                .build();
        courseRepository.save(course);

        SectionEntity section = SectionEntity.builder()
                .name(authorRequest.getSectionName())
                .order(authorRequest.getSectionOrder())
                .course(course)
                .build();
        sectionRepository.save(section);

        VideoEntity video = VideoEntity.builder()
                .name(authorRequest.getResourceName())
                .size(authorRequest.getResourceSize())
                .url(authorRequest.getResourceUrl())
                .duration(10)
                .build();
        videoRepository.save(video);

        LectureEntity lecture = LectureEntity.builder()
                .name(authorRequest.getLectureName())
                .section(section)
                .resource(video)
                .build();
        lectureRepository.save(lecture);

        return modelMapper.map(author, AuthorResponse.class);
    }

    @Override
    public List<Author> getAuthors() {

        return authorRepository.findAll().stream().map(authorEntity -> modelMapper.map(authorEntity, Author.class)).toList();
    }

    @Override
    public Author getAuthorById(Long id) {

        return authorRepository.findById(id).map(authorEntity -> modelMapper.map(authorEntity, Author.class)).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public List<Author> getAuthorsByName(String name) {

        return authorRepository.findByNameContainingIgnoreCase(name).stream().map(authorEntity -> modelMapper.map(authorEntity, Author.class)).toList();
    }

    @Override
    public Map<String, String> countOfAuthorsByAge(int age) {

        return Map.of("count", String.valueOf(authorRepository.countAllByAgeGreaterThanEqual(age)));
    }

    @Override
    public Map<String, String> deleteAuthorsByAge(int age) {

        return Map.of("deleted", String.valueOf(authorRepository.deleteAllByAge(age)));
    }

    @Override
    public Map<String, String> deleteAuthorsByEmailLikes(String email) {

        return Map.of("deleted", String.valueOf(authorRepository.deleteByEmailIsLike(email)));
    }

    @Override
    public List<Author> getAuthorsByAgeLessThanEqual(int age) {

        return authorRepository.findDistinctByNameNotNullAndAgeLessThanEqual(age).stream().map(authorEntity -> modelMapper.map(authorEntity, Author.class)).toList();
    }

    @Override
    public List<Author> getAuthorsByNameAndAgeGreaterThanEqual(String name, int age) {

        return authorRepository.findByNameIsLikeAndAgeGreaterThanEqual(name, age).stream().map(authorEntity -> modelMapper.map(authorEntity, Author.class)).toList();
    }

    @Override
    public List<Author> getAuthorsByNameStartingWith(String name) {

        return authorRepository.findAllByNameStartsWithIgnoreCase(name).stream().map(authorEntity -> modelMapper.map(authorEntity, Author.class)).toList();
    }

    @Override
    public List<Author> getAuthorsByEmailIn(List<String> names) {

        return authorRepository.findAllByEmailIn(names).stream().map(authorEntity -> modelMapper.map(authorEntity, Author.class)).toList();
    }

    @Override
    public Map<String, String> countOfAuthorsBeforeCreatedDate() {

        return Map.of("count", String.valueOf(authorRepository.countAllByCreationDateBefore(LocalDateTime.now())));
    }

    @Override
    public List<AuthorResponse> addFakeAuthors(int count) {

        for (int i = 0; i < count; i++) {

            Faker faker = new Faker();

            AuthorEntity author = AuthorEntity.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .country(Country.IND)
                    .age(faker.number().numberBetween(20, 60))
                    .build();
            authorRepository.save(author);

            CourseEntity course = CourseEntity.builder()
                    .title(faker.book().title())
                    .description(faker.lorem().sentence(10))
                    .authors(Set.of(author))
                    .build();
            courseRepository.save(course);

            SectionEntity section = SectionEntity.builder()
                    .name(faker.book().genre())
                    .order(faker.number().numberBetween(1, 25))
                    .course(course)
                    .build();
            sectionRepository.save(section);

            VideoEntity video = VideoEntity.builder()
                    .name(faker.file().fileName())
                    .size(faker.number().numberBetween(100, 1000))
                    .url(faker.internet().url())
                    .duration(faker.number().numberBetween(5, 30))
                    .build();
            videoRepository.save(video);

            LectureEntity lecture = LectureEntity.builder()
                    .name(faker.book().title())
                    .section(section)
                    .resource(video)
                    .build();
            lectureRepository.save(lecture);
        }

        return authorRepository.findAll().stream().map(authorEntity -> modelMapper.map(authorEntity, AuthorResponse.class)).toList();
    }

    @Override
    public AuthorResponse updateAuthorById(Long id, Author authorRequest) {

        AuthorEntity author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found: " + id));
        author.setName(authorRequest.getName());
        author.setEmail(authorRequest.getEmail());
        author.setCountry(authorRequest.getCountry());
        author.setAge(authorRequest.getAge());

        return modelMapper.map(authorRepository.save(author), AuthorResponse.class);
    }

    @Override
    public Map<String, String> updateAuthorNameByEmail(String name, String email) {

        return Map.of("updated", String.valueOf(authorRepository.updateNameByEmail(name, email)));
    }

    @Override
    public List<Author> getAuthorsByCountry(Country country) {

        return authorRepository.findByCountryNamedQuery(country).stream().map(authorEntity -> modelMapper.map(authorEntity, Author.class)).toList();
    }

    @Override
    public Map<String, String> updateAuthorByCountryById(Country country, Long id) {

        return Map.of("updated", String.valueOf(authorRepository.updateAuthorCountryByIdNamedQuery(country, id)));
    }

    @Override
    public Map<String, String> deleteAuthorsByCountry(Country country) {

        return Map.of("deleted", String.valueOf(authorRepository.deleteByAuthorCountryNamedQuery(country)));
    }

    @Override
    public Map<String, String> deleteAuthorsByAgeGreaterThan(int age) {

        return Map.of("deleted", String.valueOf(authorRepository.deleteByAgeGreaterThan(age)));
    }

    @Override
    public List<Author> getAuthorByNameLikeAndNotLikeAndAgeGreaterThanEqual(String likeName, String notLikeName, int age) {

        /**
         * select
         *         ae1_0.id,
         *         ae1_0.author_age,
         *         ae1_0.author_country,
         *         ae1_0.creation_date,
         *         ae1_0.author_email,
         *         ae1_0.last_updated_date,
         *         ae1_0.author_name
         *     from
         *         author ae1_0
         *     where
         *         upper(ae1_0.author_name) like ? escape ''
         *         and upper(ae1_0.author_name) not like ? escape ''
         *         and ae1_0.author_age>=?
         */
        Specification<AuthorEntity> specification = Specification
                .where(AuthorSpecification.nameLike(likeName))
                .and(AuthorSpecification.nameNotLike(notLikeName))
                .and(AuthorSpecification.ageGreaterThanOrEqual(age));

        return authorRepository.findAll(specification).stream().map(authorEntity -> modelMapper.map(authorEntity, Author.class)).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public Map<String, String> getValueFromProcedure(String value) {

        return Map.of("value", authorRepository.getValueFromProcedure(value));
    }
}
