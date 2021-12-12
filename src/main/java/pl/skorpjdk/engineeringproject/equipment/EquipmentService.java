package pl.skorpjdk.engineeringproject.equipment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public List<EquipmentDto> getEquipment(){
        return equipmentRepository.findAll().stream()
                .map(new MapperEquipment()::toDto)
                .collect(Collectors.toList());
    }
}
