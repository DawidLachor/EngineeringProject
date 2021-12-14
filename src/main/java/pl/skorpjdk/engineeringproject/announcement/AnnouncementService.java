package pl.skorpjdk.engineeringproject.announcement;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.skorpjdk.engineeringproject.announcement.AnnouncementRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public List<AnnouncementDto> getAnnouncements() {
        return announcementRepository.findAll().stream()
                .map(new MapperAnnouncement()::toDto)
                .collect(Collectors.toList());
    }

    public AnnouncementDto getAnnouncement(Long id) {
        Optional<Announcement> byId = announcementRepository.findById(id);
        if (byId.isPresent()){
            return new MapperAnnouncement().toDto(byId.get());
        } else {
            throw new IllegalStateException("");
        }
    }
}
