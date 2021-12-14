package pl.skorpjdk.engineeringproject.car;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.car.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
