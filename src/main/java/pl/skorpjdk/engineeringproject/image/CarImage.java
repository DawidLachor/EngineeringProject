package pl.skorpjdk.engineeringproject.image;

import lombok.*;
import org.hibernate.Hibernate;
import pl.skorpjdk.engineeringproject.announcement.Announcement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "CAR_IMAGE")
public class CarImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_car_image")
    private Long id;
    private String url;

    @ManyToOne
    private Announcement announcement;

    public CarImage(String url, Announcement announcement) {
        this.url = url;
        this.announcement = announcement;
    }

    public CarImage(String url) {
        this.url = url;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CarImage carImage = (CarImage) o;
        return id != null && Objects.equals(id, carImage.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
