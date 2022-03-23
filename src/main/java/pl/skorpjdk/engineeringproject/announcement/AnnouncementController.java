package pl.skorpjdk.engineeringproject.announcement;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping("announcement/{id}")
    public ResponseEntity<?> getAnnouncement(@PathVariable Long id) {
        OneAnnouncement announcement = announcementService.getAnnouncement(id);
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }

    @PostMapping("announcements")
    public ResponseEntity<?> getAnnouncement(@RequestBody Announcements announcements) {
        List<AnnouncementDto> announcement = announcementService.getAnnouncements(announcements);
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }

    @GetMapping("announcements")
    public ResponseEntity<?> getAnnouncements() {
        List<AnnouncementDto> announcement = announcementService.getAllAnnouncements();
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }

    @PostMapping("announcement")
    public ResponseEntity<?> saveAnnouncement(@RequestBody AnnouncementSave announcementSave) {
        Long id = announcementService.saveAnnouncements(announcementSave);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("announcements/my-announcement")
    public ResponseEntity<?> getMyAnnouncements() {
        List<AnnouncementDto> announcement = announcementService.getAllMyAnnouncements();
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }

    @PostMapping("announcements/my-announcement/delete")
    public ResponseEntity<?> deleteMyAnnouncements(@RequestBody Long id) {
        announcementService.deleteMyAnnouncements(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("announcement/edit/{id}")
    public ResponseEntity<?> editAnnouncements(@PathVariable Long id) {
        AnnouncementSave announcementSave = announcementService.editMyAnnouncements(id);
        return new ResponseEntity<>(announcementSave, HttpStatus.OK);
    }


}
