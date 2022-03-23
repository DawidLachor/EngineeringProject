package pl.skorpjdk.engineeringproject.car;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CarDto {

    private Long id;
    private LocalDate productionDate;
    private String vin;
    private String color;
    private String mileage;
    private String registration;
    private String power;
    private String capacity;
    private int numberOfSeats;
    private int numberOfDoor;
    private boolean neverCrashed;
    private String registeredFrom;
    private LocalDate firstRegistration;

    public boolean getNeverCrashed() {
        return neverCrashed;
    }
}
