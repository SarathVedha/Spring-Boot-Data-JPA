package com.vedha.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vedha.util.Country;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(
        name = "author"
)
@NamedQuery( // Named query, defined in entity class
        name = "AuthorEntity.findByCountryNamedQuery",
        query = "select ae from AuthorEntity ae where ae.country = :country"
)
@NamedQueries( // Multiple named queries can be defined in a single entity class
        {
                @NamedQuery(
                        name = "AuthorEntity.updateAuthorCountryByIdNamedQuery",
                        query = "update AuthorEntity ae set ae.country = :country where ae.id = :id"
                ),
                @NamedQuery(
                        name = "AuthorEntity.deleteByAuthorCountryNamedQuery",
                        query = "delete from AuthorEntity ae where ae.country = :country"
                )
        }
)
@NamedStoredProcedureQuery(
        name = "callSHA256_HEX",
        procedureName = "SHA256_HEX",
        parameters = {
                @StoredProcedureParameter(
                        name = "value",
                        type = String.class,
                        mode = ParameterMode.IN
                )
        },
        resultClasses = String.class
)
public class AuthorEntity extends BaseEntity {

    // GenerationType.AUTO is the default strategy,
    // Auto means that the persistence provider(db driver) will automatically choose the most appropriate strategy for the particular database like SEQUENCE, IDENTITY, TABLE
    // GenerationType.IDENTITY is the most common strategy, it is used to generate a unique primary key for the entity
    // GenerationType.SEQUENCE is used to generate a unique primary key for the entity, it is used when the primary key is generated by a database sequence
    // GenerationType.TABLE is used to generate a unique primary key for the entity, it is used when the primary key is generated by a database table
    // SEQUENCE is not supported by all databases, it is supported by Oracle, PostgresSQL, DB2, and some other databases
    // TABLE is the least efficient strategy, it is used when the primary key is generated by a database table
    // IDENTITY is the most efficient strategy, it is used when the primary key is generated by the database
    @Id
    @GeneratedValue
    private Long id;

    @Column(
            name = "author_name",
            length = 35,
            nullable = false
    )
    private String name;

    @Column(
            name = "author_email",
            length = 50,
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            name = "author_country",
            length = 3,
            nullable = false,
            columnDefinition = "varchar(3) default 'IND'"
    )
    @Enumerated
    private Country country;

    @Column(
            name = "author_age",
            nullable = false,
            columnDefinition = "int default 18"
    )
    private Integer age;

    @JsonManagedReference
    @ToString.Exclude
    @ManyToMany(
            mappedBy = "authors",
            fetch = FetchType.LAZY
    )
    private Set<CourseEntity> courses;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AuthorEntity that = (AuthorEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
