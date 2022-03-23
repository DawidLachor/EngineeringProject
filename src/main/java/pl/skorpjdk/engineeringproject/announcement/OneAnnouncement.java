package pl.skorpjdk.engineeringproject.announcement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Setter
public class OneAnnouncement {
    private String title;
    private String price;
    private String mark;
    private String model;
    private LocalDate year_of_production;
    private String mileage;
    private String capacity;
    private String power;
    private String gas;
    private String transmission;
    private Boolean crash;
    private String typeBody;
    private Integer doors;
    private Integer seats;
    private String color;
    private String registration;
    private LocalDate first_registration;
    private String vin;
    private String description;
    private String location;
    private String phone;
}
