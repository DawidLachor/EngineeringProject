package pl.skorpjdk.engineeringproject.combustion;

import lombok.*;
import org.hibernate.Hibernate;
import pl.skorpjdk.engineeringproject.engine.Engine;

import javax.persistence.*;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "CAPACITY")
public class Combustion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_combustion")
    private Long id;
    private Integer city;
    @Column(name = "out_of_tower")
    private Integer outOfTower;
    private Integer mixed;

    @OneToOne(targetEntity = Engine.class)
    private Engine engine;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Combustion that = (Combustion) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
