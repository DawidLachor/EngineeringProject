package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "CAR_IMAGE")
public class CarImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_car_image")
    private Long id;
    private String name;
    private byte[] image;

    @ManyToOne(targetEntity = Car.class,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Car car;
}