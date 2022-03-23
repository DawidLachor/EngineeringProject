package pl.skorpjdk.engineeringproject.car;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.car.Car;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
//    Optional<Car> findByAnnouncement(Long id);
}
