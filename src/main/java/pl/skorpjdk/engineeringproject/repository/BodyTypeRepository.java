package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.BodyType;

public interface BodyTypeRepository extends JpaRepository<BodyType, Long> {
}
