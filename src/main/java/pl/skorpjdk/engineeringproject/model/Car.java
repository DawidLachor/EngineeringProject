package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Data
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
    @Column(length = 10)
    private String registration;
    @Column(name = "number_of_seats")
    private int numberOfSeats;
    @Column(name = "number_of_door")
    private int numberOfDoor;
    private String state;
    @Column(name = "never_creashed")
    private boolean neverCrashed;
    @Column(name = "registered_in_poland")
    private boolean registeredInPoland;

    @OneToMany(targetEntity = BodyType.class)
    private List<BodyType> bodyTypes;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = CarImage.class)
    private List<CarImage> carImages;
    @ManyToMany(targetEntity = Equipment.class)
    @JoinTable(name = "EQUIPMENT_CAR",
            joinColumns = {@JoinColumn(name = "id_car", referencedColumnName = "id_car")},
            inverseJoinColumns = {@JoinColumn(name = "id_equipment", referencedColumnName = "id_equipment")}
    )
    private List<Equipment> equipments;
    @OneToMany(targetEntity = Transmission.class)
    private List<Transmission> transmissions;
    @OneToOne(targetEntity = Announcement.class)
    private Announcement announcement;
}
