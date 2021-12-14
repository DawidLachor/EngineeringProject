package pl.skorpjdk.engineeringproject.car;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
public class CarDto {

    private Long id;
    private LocalDateTime productionDate;
    private String vin;
    private String color;
    private Integer mileage;
    private String registration;
    private int numberOfSeats;
    private int numberOfDoor;
    private String state;
    private boolean neverCrashed;
    private boolean registeredInPoland;

    public boolean getNeverCrashed() {
        return neverCrashed;
    }

    public boolean getRegisteredInPoland() {
        return registeredInPoland;
    }
}
