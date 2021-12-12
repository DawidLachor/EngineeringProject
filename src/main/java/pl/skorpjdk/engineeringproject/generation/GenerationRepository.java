package pl.skorpjdk.engineeringproject.generation;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.generation.Generation;

public interface GenerationRepository extends JpaRepository<Generation, Long> {
}
