package pl.skorpjdk.engineeringproject.typeEngine;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeEngineService {

    private final TypeEngineRepository typeRepository;

    public List<TypeEngineDto> getTypeEngineList() {
        return typeRepository.findAll().stream()
                .map(new MapperTypeEngine()::toDto)
                .collect(Collectors.toList());
    }

    public TypeEngine getTypeEngine(Long id) {
        Optional<TypeEngine> byId = typeRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }else {
            throw new IllegalArgumentException("The engine with such id doesn't exist");
        }
    }
}
