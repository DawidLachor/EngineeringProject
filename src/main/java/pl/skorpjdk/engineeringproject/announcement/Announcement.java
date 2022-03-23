package pl.skorpjdk.engineeringproject.announcement;

import lombok.*;
import org.hibernate.Hibernate;
import pl.skorpjdk.engineeringproject.car.Car;
import pl.skorpjdk.engineeringproject.account.Account;
import pl.skorpjdk.engineeringproject.image.CarImage;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "ANNOUNCEMENT")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_announcement")
    private Long id;
    private boolean active;
    private boolean delete;
    private String title;
    private String description;
    private String price;
    private String location;
    private LocalDateTime created;
    private LocalDateTime modification;
    private String phone;

    @OneToOne
    private Car car;
    @ManyToOne
    @JoinColumn(name = "id_account", nullable = false)
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Announcement that = (Announcement) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
