package pl.skorpjdk.engineeringproject.typeEngine;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "TYPE_ENGINE")
public class TypeEngine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_type_engine")
    private Long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TypeEngine that = (TypeEngine) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
