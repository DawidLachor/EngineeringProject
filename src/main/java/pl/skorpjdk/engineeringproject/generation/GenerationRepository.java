package pl.skorpjdk.engineeringproject.generation;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.generation.Generation;

import java.util.List;
import java.util.Optional;

public interface GenerationRepository extends JpaRepository<Generation, Long> {

    Optional<List<Generation>> findAllByModel_Id(Long idModel);
}
