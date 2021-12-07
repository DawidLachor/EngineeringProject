package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.transmission.Transmission;

public interface TransmissionRepository extends JpaRepository<Transmission, Long> {
}
