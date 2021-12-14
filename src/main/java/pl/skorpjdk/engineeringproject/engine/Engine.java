package pl.skorpjdk.engineeringproject.engine;

import lombok.*;
import org.hibernate.Hibernate;
import pl.skorpjdk.engineeringproject.combustion.Combustion;
import pl.skorpjdk.engineeringproject.typeEngine.TypeEngine;

import javax.persistence.*;
import java.util.Objects;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "ENGINE")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_engine")
    private Long id;
    private Integer power;
    private Integer capacity;

    @ManyToOne(targetEntity = TypeEngine.class)
    private TypeEngine typeEngine;
    @OneToOne(targetEntity = Combustion.class)
    private Combustion combustion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Engine engine = (Engine) o;
        return id != null && Objects.equals(id, engine.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
