package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
