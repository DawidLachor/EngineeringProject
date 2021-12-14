package pl.skorpjdk.engineeringproject.car;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("car")
    public ResponseEntity<?> getCars(){
        List<CarDto> cars = carService.getCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
