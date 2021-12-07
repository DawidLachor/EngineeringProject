package pl.skorpjdk.engineeringproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skorpjdk.engineeringproject.service.AnnouncementService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/announcement/")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping("{id_announcement}")
    public ResponseEntity<?> getAnnouncement(@PathVariable("id_announcement") long idAnnouncement){
        return announcementService.getAnnouncement(idAnnouncement);
    }
}
