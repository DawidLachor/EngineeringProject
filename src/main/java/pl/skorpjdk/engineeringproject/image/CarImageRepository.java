package pl.skorpjdk.engineeringproject.image;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.announcement.Announcement;

import java.util.List;
import java.util.Optional;

public interface CarImageRepository extends JpaRepository<CarImage, Long> {
    Optional<List<CarImage>> findByAnnouncement(Announcement announcement);
}
