package pl.skorpjdk.engineeringproject.model;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.Model;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findAllByMark_Id(Long id);
}
