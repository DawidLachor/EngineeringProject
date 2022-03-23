package pl.skorpjdk.engineeringproject.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<CarDto> getCars() {
        return carRepository.findAll().stream()
                .map(new MapperCar()::toDto)
                .collect(Collectors.toList());
    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

//    public Car findByAnnouncement(Long id){
//       return carRepository.findByAnnouncement(id).get();
//    }
}
