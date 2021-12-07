package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.skorpjdk.engineeringproject.bodyType.BodyType;
import pl.skorpjdk.engineeringproject.transmission.Transmission;
import pl.skorpjdk.engineeringproject.typeEngine.TypeEngine;

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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CAR_IMAGE_CAR",
            joinColumns = {@JoinColumn(name = "id_car", referencedColumnName = "id_car")},
            inverseJoinColumns = {@JoinColumn(name = "id_car_image", referencedColumnName = "id_car_image")}
    )
    private List<CarImage> carImages;
    @ManyToMany(targetEntity = Equipment.class)
    @JoinTable(name = "EQUIPMENT_CAR",
            joinColumns = {@JoinColumn(name = "id_car", referencedColumnName = "id_car")},
            inverseJoinColumns = {@JoinColumn(name = "id_equipment", referencedColumnName = "id_equipment")}
    )
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
}
