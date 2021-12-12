package pl.skorpjdk.engineeringproject.generation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
public class GenerationDto {

    private Long id;
    private String name;
    private LocalDate startProduction;
    private LocalDate endProduction;
}
