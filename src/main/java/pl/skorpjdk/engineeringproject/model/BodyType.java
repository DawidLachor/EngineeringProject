package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "BODY_TYPE")
public class BodyType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_body_type")
    private long id;
    private String name;
}
