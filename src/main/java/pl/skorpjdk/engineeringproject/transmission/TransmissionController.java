package pl.skorpjdk.engineeringproject.transmission;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class TransmissionController {

    private TransmissionService transmissionService;

    @GetMapping("transmissions")
    public ResponseEntity<?> getTransmissions(){
        List<TransmissionDto> transmissions = transmissionService.getTransmissions();
        return new ResponseEntity<>(transmissions, HttpStatus.OK);
    }
}
