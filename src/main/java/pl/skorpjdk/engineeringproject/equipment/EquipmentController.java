package pl.skorpjdk.engineeringproject.equipment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping("equipment")
    public ResponseEntity<?> getEquipment(){
        List<EquipmentDto> equipment = equipmentService.getEquipment();
        return new ResponseEntity<>(equipment, HttpStatus.OK);
    }


}
