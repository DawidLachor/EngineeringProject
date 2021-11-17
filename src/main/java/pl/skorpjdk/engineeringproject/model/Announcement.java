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
    private boolean active;
    private boolean delete;
    private String title;
    private String description;
    private BigDecimal price;
    private String location;
    private String type;
    private LocalDateTime created;
    private LocalDateTime modification;

    @OneToOne
    private Car car;
    @ManyToOne
    @JoinColumn(name = "id_account", nullable = false)
    private Account account;
}
