package pl.skorpjdk.engineeringproject.car;

import lombok.*;
import org.hibernate.Hibernate;
import pl.skorpjdk.engineeringproject.bodyType.BodyType;
import pl.skorpjdk.engineeringproject.equipment.Equipment;
import pl.skorpjdk.engineeringproject.mark.Mark;
import pl.skorpjdk.engineeringproject.image.CarImage;
import pl.skorpjdk.engineeringproject.transmission.Transmission;
import pl.skorpjdk.engineeringproject.typeEngine.TypeEngine;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_car")
    private Long id;
    @Column(name = "production_date")
    private LocalDateTime productionDate;
    @Column(length = 17)
    private String vin;
    private String color;
    private Integer mileage;
    @Column(length = 10)
    private String registration;
    @Column(name = "number_of_seats")
    private int numberOfSeats;
    @Column(name = "number_of_door")
    private int numberOfDoor;
    private String state;
    @Column(name = "never_crashed")
    private boolean neverCrashed;
    @Column(name = "registered_in_poland")
    private boolean registeredInPoland;

    @OneToOne
    @JoinColumn(name = "id_body_type")
    private BodyType bodyTypes;
    @ManyToMany(targetEntity = Equipment.class)
    @JoinTable(name = "EQUIPMENT_CAR",
            joinColumns = {@JoinColumn(name = "id_car", referencedColumnName = "id_car")},
            inverseJoinColumns = {@JoinColumn(name = "id_equipment", referencedColumnName = "id_equipment")}
    )
    @ToString.Exclude
    private List<Equipment> equipments;
    @OneToOne
    @JoinColumn(name = "id_transmission")
    private Transmission transmission;
    @OneToOne
    @JoinColumn(name = "id_type_engine")
    private TypeEngine typeEngine;
    @OneToOne
    @JoinColumn(name = "id_mark")
    private Mark mark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Car car = (Car) o;
        return id != null && Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public boolean getNeverCrashed() {
        return neverCrashed;
    }

    public boolean getRegisteredInPoland() {
        return registeredInPoland;
    }
}
