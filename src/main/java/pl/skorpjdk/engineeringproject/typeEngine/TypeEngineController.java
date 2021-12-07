package pl.skorpjdk.engineeringproject.typeEngine;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class TypeEngineController {

    private final TypeEngineService typeEngineService;

    @GetMapping("typeEngineList")
    public ResponseEntity<?> getTypeEngineList(){
        List<TypeEngineDto> typeEngineList = typeEngineService.getTypeEngineList();
        return new ResponseEntity<>(typeEngineList, HttpStatus.OK);
    }
}
