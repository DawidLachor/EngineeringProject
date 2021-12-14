package pl.skorpjdk.engineeringproject.engine;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.engine.Engine;

public interface EngineRepository extends JpaRepository<Engine, Long> {
}
