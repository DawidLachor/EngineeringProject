package pl.skorpjdk.engineeringproject.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.skorpjdk.engineeringproject.generation.Generation;

import java.util.List;
import java.util.Optional;
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
     public Car getCar(Long id){
         Optional<Car> byId = carRepository.findById(id);
         if (byId.isPresent()){
             return byId.get();
         }else {
             throw new IllegalArgumentException("The engine with such id doesn't exist");
         }
     }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }
//    public Car findByAnnouncement(Long id){
//       return carRepository.findByAnnouncement(id).get();
//    }
}
