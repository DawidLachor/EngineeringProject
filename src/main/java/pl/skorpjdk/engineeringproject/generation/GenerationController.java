package pl.skorpjdk.engineeringproject.generation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class GenerationController {

    private final GenerationService generationService;

    @GetMapping("generation")
    public ResponseEntity<?> getGeneration(){
        List<GenerationDto> generation = generationService.getGeneration();
        return new ResponseEntity<>(generation, HttpStatus.OK);
    }

    @GetMapping("{id}/generation")
    public ResponseEntity<?> getGeneration(@PathVariable Long id){
        List<GenerationDto> generation = generationService.getGenerationByModelId(id);
        return new ResponseEntity<>(generation, HttpStatus.OK);
    }
}
