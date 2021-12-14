package pl.skorpjdk.engineeringproject.announcement;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class AnnouncementDto {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String location;
    private String type;
    private LocalDateTime created;
}
