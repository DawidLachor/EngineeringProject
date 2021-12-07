package pl.skorpjdk.engineeringproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.skorpjdk.engineeringproject.repository.AnnouncementRepository;

@Service
@RequiredArgsConstructor
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public ResponseEntity<?> getAnnouncement(long idAnnouncement) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
