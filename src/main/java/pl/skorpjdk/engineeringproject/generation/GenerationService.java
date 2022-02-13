package pl.skorpjdk.engineeringproject.generation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenerationService {

    private GenerationRepository generationRepository;


    public List<GenerationDto> getGeneration() {
        return generationRepository.findAll().stream()
                .map(new MapperGeneration()::toDto)
                .collect(Collectors.toList());
    }
}
