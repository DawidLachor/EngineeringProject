package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.CarImage;

public interface CarImageRepository extends JpaRepository<CarImage, Long> {
}
