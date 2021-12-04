package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "TRANSMISSION")
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transmission")
    private Long id;
    private String type;
    @Column(name = "number_of_gears")
    private int numberOfGears;
}
