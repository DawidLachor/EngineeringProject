package pl.skorpjdk.engineeringproject.mark;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarkService {

    private final MarkRepository markRepository;

    public List<MarkDto> getMarks() {
        return markRepository.findAll().stream()
                .map(new MapperMark()::toDto)
                .collect(Collectors.toList());
    }
}
