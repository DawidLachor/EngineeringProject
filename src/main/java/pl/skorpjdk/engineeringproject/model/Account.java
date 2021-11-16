package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_account")
    private Long id;
    private String name;
    private String surname;
    private String location;
    private Integer phone;

    @OneToMany(targetEntity = Announcement.class)
    List<Announcement> announcements;
}
