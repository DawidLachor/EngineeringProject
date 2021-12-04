package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.Generation;

public interface GenerationRepository extends JpaRepository<Generation, Long> {
}
