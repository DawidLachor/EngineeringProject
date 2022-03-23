package pl.skorpjdk.engineeringproject.announcement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.skorpjdk.engineeringproject.announcement.Announcement;

import java.util.Optional;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
