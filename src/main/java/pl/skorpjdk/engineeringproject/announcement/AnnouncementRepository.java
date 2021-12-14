package pl.skorpjdk.engineeringproject.announcement;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.announcement.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
