package pl.skorpjdk.engineeringproject.bodyType;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BodyTypeService {

    private final BodyTypeRepository bodyTypeRepository;

    public List<BodyTypeDto> getBodyTypes() {
        return bodyTypeRepository.findAll().stream().
                map(new MapperBodyType()::toDto)
                .collect(Collectors.toList());
    }

    public BodyType getBodyType(Long id){
        return bodyTypeRepository.findById(id).get();
    }
}
