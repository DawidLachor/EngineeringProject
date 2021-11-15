package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "EQUIPMENT")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_equipment")
    private Long id;
    private String name;

    @ManyToMany(targetEntity = Car.class)
    @JoinTable(name = "EQUIPMENT_CAR",
            joinColumns = {@JoinColumn(name = "id_equipment", referencedColumnName = "id_equipment")},
            inverseJoinColumns = {@JoinColumn(name = "id_car", referencedColumnName = "id_car")}
    )
    private List<Car> cars;
}
