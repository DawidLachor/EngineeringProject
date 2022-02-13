package pl.skorpjdk.engineeringproject.transmission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransmissionService {

    private TransmissionRepository transmission;

    public List<TransmissionDto> getTransmissions() {
        return transmission.findAll().stream()
                .map(new MapperTransmission()::toDto)
                .collect(Collectors.toList());
    }
}
