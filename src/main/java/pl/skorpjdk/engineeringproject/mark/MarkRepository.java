package pl.skorpjdk.engineeringproject.mark;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.mark.Mark;

public interface MarkRepository extends JpaRepository<Mark, Long> {
}
