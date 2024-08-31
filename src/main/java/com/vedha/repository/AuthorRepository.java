package com.vedha.repository;

import com.vedha.entity.AuthorEntity;
import com.vedha.util.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>, JpaSpecificationExecutor<AuthorEntity> {

    // Custom query methods, update, delete are Modifying, So requires transactional annotation, throws exception TransactionRequiredException
    @Transactional
    @Modifying
    @Query("update AuthorEntity ae set ae.name = :name where ae.email = :email")
    int updateNameByEmail(@Param("name") String updateName, String email);

    // Custom query methods, update, delete are Modifying, So requires transactional annotation, throws exception TransactionRequiredException
    @Transactional
    @Modifying
    @Query("delete from AuthorEntity ae where ae.age > :age")
    int deleteByAgeGreaterThan(int age);

    // Named query, defined in entity class
    List<AuthorEntity> findByCountryNamedQuery(@Param("country") Country countryCode);

    // Named query methods, update, delete are Modifying, So requires transactional annotation, throws exception TransactionRequiredException
    // Named query, defined in entity class
    @Transactional
    @Modifying
    int updateAuthorCountryByIdNamedQuery(@Param("country") Country countryCode, @Param("id") Long id);

    // Named query methods, update, delete are Modifying, So requires transactional annotation, throws exception TransactionRequiredException
    // Named query, defined in entity class
    @Transactional
    @Modifying
    int deleteByAuthorCountryNamedQuery(@Param("country") Country countryCode);

    // Named stored procedure query, defined in entity class

    /**
     * {call SHA256_HEX(?)}
     */
    @Transactional(readOnly = true)
    @Procedure(name = "callSHA256_HEX")
    // Named stored procedure query, defined in entity class
    String getValueFromProcedure(@Param("value") String value);

    /**
     * select *
     * from
     * author
     * where
     * upper(author_name) like upper(?)
     */
    List<AuthorEntity> findByNameContainingIgnoreCase(String name); // Name should match with entity field name with the First letter in uppercase

    /**
     * select *
     * from
     * author
     * where
     * age >= ?
     */
    int countAllByAgeGreaterThanEqual(int age);

    /**
     * delete from
     * author
     * where
     * age = ?
     */
    int deleteAllByAge(int age);

    /**
     * delete from
     * author
     * where
     * author_email like ?
     */
    int deleteByEmailIsLike(String email);

    /**
     * select distinct *
     * from
     * author
     * where
     * author_name is not null and age <= ?
     */
    List<AuthorEntity> findDistinctByNameNotNullAndAgeLessThanEqual(int age);

    /**
     * select *
     * from
     * author
     * where
     * author_name like ? and age >= ?
     */
    List<AuthorEntity> findByNameIsLikeAndAgeGreaterThanEqual(String name, int age);

    /**
     * select *
     * from
     * author ae1_0
     * where
     * upper(ae1_0.author_name) like upper(?)
     */
    List<AuthorEntity> findAllByNameStartsWithIgnoreCase(String name);

    /**
     * select *
     * from
     * author
     * where
     * author_email in (?)
     */
    List<AuthorEntity> findAllByEmailIn(List<String> emails);

    /**
     * select count(*)
     * from
     * author
     * where
     * creation_date < ?
     */
    int countAllByCreationDateBefore(LocalDateTime creationDate);

}
