package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "MARK")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_mark")
    private Long id;
    private String name;
    @ManyToOne(targetEntity = Car.class)
    private Car car;
    @OneToMany(targetEntity = Model.class)
    private List<Model> models;
}
