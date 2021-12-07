package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor
@Data
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
}
