package com.vedha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "lecture"
)
public class LectureEntity extends BaseEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(
            name = "lecture_name",
            nullable = false
    )
    private String name;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "section_id",
            referencedColumnName = "id" // SectionEntity
    )
    private SectionEntity section;

    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "resource_id",
            referencedColumnName = "id" // ResourceEntity
    )
    private ResourceEntity resource;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        LectureEntity that = (LectureEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
