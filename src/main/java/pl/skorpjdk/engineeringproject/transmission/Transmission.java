package pl.skorpjdk.engineeringproject.transmission;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "TRANSMISSION")
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transmission")
    private Long id;
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Transmission that = (Transmission) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
