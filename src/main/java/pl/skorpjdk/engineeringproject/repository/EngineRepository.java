package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.Account;
import pl.skorpjdk.engineeringproject.model.Engine;

public interface EngineRepository extends JpaRepository<Engine, Long> {
}
