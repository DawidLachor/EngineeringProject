package pl.skorpjdk.engineeringproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "ANNOUNCEMENT")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_announcement")
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String location;
    private String type;
    private LocalDateTime created;
    private LocalDateTime modification;

    @OneToOne(targetEntity = Car.class)
    private Car car;
    @ManyToOne(targetEntity = Account.class)
    private Account account;
}
