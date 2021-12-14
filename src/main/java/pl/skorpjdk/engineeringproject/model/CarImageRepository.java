package pl.skorpjdk.engineeringproject.model;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.CarImage;

public interface CarImageRepository extends JpaRepository<CarImage, Long> {
}
