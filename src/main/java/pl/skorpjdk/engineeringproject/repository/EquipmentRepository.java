package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.Account;
import pl.skorpjdk.engineeringproject.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
