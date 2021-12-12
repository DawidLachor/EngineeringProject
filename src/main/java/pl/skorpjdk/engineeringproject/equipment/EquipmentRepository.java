package pl.skorpjdk.engineeringproject.equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.equipment.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
