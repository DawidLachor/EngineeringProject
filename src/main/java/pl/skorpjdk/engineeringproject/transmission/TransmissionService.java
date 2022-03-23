package pl.skorpjdk.engineeringproject.transmission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.skorpjdk.engineeringproject.typeEngine.TypeEngine;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransmissionService {

    private final TransmissionRepository transmission;

    public List<TransmissionDto> getTransmissions() {
        return transmission.findAll().stream()
                .map(new MapperTransmission()::toDto)
                .collect(Collectors.toList());
    }

    public Transmission getTransmission(Long id) {

        Optional<Transmission> byId = transmission.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }else {
            throw new IllegalArgumentException("The engine with such id doesn't exist");
        }
    }
}
