package pl.skorpjdk.engineeringproject.announcement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AnnouncementDto {

    private Long id;
    private String title;
    private String mark;
    private String model;
    private LocalDate year_of_production;
    private String mileage;
    private String capacity;
    private String power;
    private String gas;
    private String location;
    private String price;
    private String imageUrl;

    public AnnouncementDto(Long id, String title, String mark, String model, LocalDate year_of_production, String mileage, String capacity, String power, String gas, String location, String price) {
        this.id = id;
        this.title = title;
        this.mark = mark;
        this.model = model;
        this.year_of_production = year_of_production;
        this.mileage = mileage;
        this.capacity = capacity;
        this.power = power;
        this.gas = gas;
        this.location = location;
        this.price = price;
    }
}


