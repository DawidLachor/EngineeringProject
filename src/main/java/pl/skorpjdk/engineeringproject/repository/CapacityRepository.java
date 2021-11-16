package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.Account;
import pl.skorpjdk.engineeringproject.model.Capacity;

public interface CapacityRepository extends JpaRepository<Capacity, Long> {
}
