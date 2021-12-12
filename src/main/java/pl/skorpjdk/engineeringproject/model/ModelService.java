package pl.skorpjdk.engineeringproject.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepository;

    public List<ModelDto> getModels() {
        return modelRepository.findAll().stream()
                .map(new MapperModel()::toDto)
                .collect(Collectors.toList());
    }
}
