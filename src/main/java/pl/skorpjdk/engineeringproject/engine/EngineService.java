package pl.skorpjdk.engineeringproject.engine;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EngineService {

    private EngineRepository engineRepository;

    public List<EngineDto> getEngines(){
        return engineRepository.findAll().stream()
                .map(new MapperEngine()::toDto)
                .collect(Collectors.toList());
    }

    public EngineDto getEngine(Long id) {
        Optional<Engine> byId = engineRepository.findById(id);
        if (byId.isPresent()){
            return new MapperEngine().toDto(byId.get());
        }else {
            throw new IllegalArgumentException("The engine with such id doesn't exist");
        }
    }
}
