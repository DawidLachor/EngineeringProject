package pl.skorpjdk.engineeringproject.announcement;

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
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping("announcement/{id}")
    public ResponseEntity<?> getAnnouncement(@PathVariable Long id) {
        AnnouncementDto announcement = announcementService.getAnnouncement(id);
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }

    @GetMapping("announcement/")
    public ResponseEntity<?> getAnnouncement() {
        List<AnnouncementDto> announcement = announcementService.getAnnouncements();
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }
}
