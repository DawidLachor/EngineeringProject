package pl.skorpjdk.engineeringproject.engine;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class EngineController {

    private final EngineService engineService;

    @GetMapping("/engine/{id}")
    public ResponseEntity<?> getEngine(@PathVariable Long id){
        EngineDto engine = engineService.getEngine(id);
        return new ResponseEntity<>(engine, HttpStatus.OK);
    }
}
