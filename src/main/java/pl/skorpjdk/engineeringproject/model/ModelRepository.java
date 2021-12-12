package pl.skorpjdk.engineeringproject.model;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
}