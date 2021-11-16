package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
