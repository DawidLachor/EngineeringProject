package pl.skorpjdk.engineeringproject.model;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @GetMapping("model")
    public ResponseEntity<?> getmodels(){
        List<ModelDto> models = modelService.getModels();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @GetMapping("{id}/model")
    public ResponseEntity<?> getmodels(@PathVariable Long id){
        List<ModelDto> models = modelService.getModelsByMarkId(id);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

}
