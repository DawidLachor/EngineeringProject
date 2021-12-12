package pl.skorpjdk.engineeringproject.equipment;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

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
}
