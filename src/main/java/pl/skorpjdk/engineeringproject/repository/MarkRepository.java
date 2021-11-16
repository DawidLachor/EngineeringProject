package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.Account;
import pl.skorpjdk.engineeringproject.model.Mark;

public interface MarkRepository extends JpaRepository<Mark, Long> {
}
