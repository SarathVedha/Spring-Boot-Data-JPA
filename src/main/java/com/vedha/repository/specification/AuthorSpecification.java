package com.vedha.repository.specification;

import com.vedha.entity.AuthorEntity;
import org.springframework.data.jpa.domain.Specification;

public final class AuthorSpecification {

    public static Specification<AuthorEntity> nameLike(String name) {

        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
    }

    public static Specification<AuthorEntity> nameNotLike(String name) {

        // root.get("name") is the same as root.get(AuthorEntity_.name)
        return (root, query, criteriaBuilder) -> criteriaBuilder.notLike(criteriaBuilder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
    }

    public static Specification<AuthorEntity> ageGreaterThanOrEqual(int age) {

        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("age"), age);
    }
}
