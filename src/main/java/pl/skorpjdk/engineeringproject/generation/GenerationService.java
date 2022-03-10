package pl.skorpjdk.engineeringproject.generation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenerationService {

    private final GenerationRepository generationRepository;


    public List<GenerationDto> getGeneration() {
        return generationRepository.findAll().stream()
                .map(new MapperGeneration()::toDto)
                .collect(Collectors.toList());
    }

    public List<GenerationDto> getGenerationByModelId(Long id) {
        Optional<List<Generation>> allByModel_id = generationRepository.findAllByModel_Id(id);
        if(allByModel_id.isPresent()){
            return  allByModel_id.get().stream()
                    .map(new MapperGeneration()::toDto)
                    .collect(Collectors.toList());
        } else {
            throw new IllegalStateException();
        }

    }
}
