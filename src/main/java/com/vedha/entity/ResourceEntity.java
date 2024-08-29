package com.vedha.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(
        name = "resource"
)
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(name = "resource_type") // for single table inheritance
public class ResourceEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(
            name = "resource_name",
            nullable = false
    )
    private String name;

    @Column(
            name = "resource_size",
            nullable = false,
            columnDefinition = "INT DEFAULT 0"
    )
    private Integer size;

    @Column(
            name = "resource_url",
            nullable = false
    )
    private String url;

    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "lecture_id",
            referencedColumnName = "id" // LectureEntity
    )
    private LectureEntity lecture;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        ResourceEntity that = (ResourceEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
