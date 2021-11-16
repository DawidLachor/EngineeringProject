package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "ENGINE")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_engine")
    private Long id;
    private Integer power;
    private Integer combustion;

    @ManyToOne(targetEntity = TypeEngine.class)
    private TypeEngine typeEngine;
    @OneToOne(targetEntity = Capacity.class)
    private Capacity capacity;
}
