package pl.skorpjdk.engineeringproject.announcement;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class AnnouncementSave {
    private Long id;
    private Long bodyType;
    private Long brand;
    private Long model;
    private Long generation;
    private String capacity;
    private String color;
    private String country_of_production;
    private boolean crash;
    private String describe;
    private Integer doors;
    private String first_registration;
    private Long gas;
    private String location;
    private String mileage;
    private String phone;
    private String power;
    private String price;
    private String registration_number;
    private Integer seats;
    private String title;
    private Long transmission;
    private String vin;
    private String year_of_production;

    public boolean getCrash() {
        return crash;
    }
}


