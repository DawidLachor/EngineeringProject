package pl.skorpjdk.engineeringproject.combustion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CombustionService {

    private final CombustionRepository combustionRepository;


    public CombustionDto getCombust(Long id) {
        Optional<Combustion> byId = combustionRepository.findById(id);
        if (byId.isPresent()){
            return new MapperCombustion().toDto(byId.get());
        } else {
            throw new IllegalArgumentException("The combustion with such id doesn't exist");
        }
    }
}
