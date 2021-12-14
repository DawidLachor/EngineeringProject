package pl.skorpjdk.engineeringproject.combustion;

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
public class CombustionController {

    private final CombustionService combustionService;

    @GetMapping("combustion/{id}")
    public ResponseEntity<?> getCombustion(@PathVariable Long id){
        CombustionDto combust = combustionService.getCombust(id);
        return new ResponseEntity<>(combust, HttpStatus.OK);
    }
}
