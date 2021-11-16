package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "MODEL")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_model")
    private Long id;
    private String name;

    @ManyToOne(targetEntity = Mark.class)
    private Mark mark;
    @OneToMany(targetEntity = Generation.class)
    private List<Generation> generations;
}
