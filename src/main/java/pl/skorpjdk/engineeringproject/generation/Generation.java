package pl.skorpjdk.engineeringproject.generation;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.skorpjdk.engineeringproject.model.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "GENERATION")
public class Generation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_generation")
    private Long id;
    private String name;
    @Column(name = "start_production")
    private LocalDate startProduction;
    @Column(name = "end_production")
    private LocalDate endProduction;

    @ManyToOne(targetEntity = Model.class)
    private Model model;

}
