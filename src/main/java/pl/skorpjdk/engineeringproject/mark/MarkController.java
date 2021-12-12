package pl.skorpjdk.engineeringproject.mark;

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
public class MarkController {

    private final MarkService markService;

    @GetMapping("mark")
    public ResponseEntity<?> getMarks(){
        List<MarkDto> marks = markService.getMarks();
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }
}
