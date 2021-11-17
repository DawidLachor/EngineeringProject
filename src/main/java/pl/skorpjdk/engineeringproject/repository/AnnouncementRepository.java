package pl.skorpjdk.engineeringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skorpjdk.engineeringproject.model.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
