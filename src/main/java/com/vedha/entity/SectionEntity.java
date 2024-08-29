package com.vedha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "section"
)
public class SectionEntity extends BaseEntity {

    @Id
    @GeneratedValue(
            generator = "section_id",
            strategy = GenerationType.TABLE
    )
    @TableGenerators(
            @TableGenerator(
                    name = "section_id",
                    table = "id_gen",
                    pkColumnName = "gen_name",
                    valueColumnName = "gen_value",
                    allocationSize = 1,
                    pkColumnValue = "section_id"
            )
    )
    private Long id;

    @Column(
            name = "section_name",
            nullable = false
    )
    private String name;

    @Column(
            name = "section_order",
            nullable = false,
            columnDefinition = "INT DEFAULT 0"
    )
    private Integer order;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "course_id" // used @Column(name = "course_id") in CourseEntity
    )
    private CourseEntity course;

    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(
            mappedBy = "section",
            fetch = FetchType.LAZY
    )
    private Set<LectureEntity> lectures;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        SectionEntity that = (SectionEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
