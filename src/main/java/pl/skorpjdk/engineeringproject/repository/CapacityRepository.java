package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.Combustion;

public interface CapacityRepository extends JpaRepository<Combustion, Long> {
}
