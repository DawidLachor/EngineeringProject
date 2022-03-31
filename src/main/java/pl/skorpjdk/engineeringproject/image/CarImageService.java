package pl.skorpjdk.engineeringproject.image;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.skorpjdk.engineeringproject.announcement.Announcement;
import pl.skorpjdk.engineeringproject.announcement.AnnouncementService;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CarImageService {

    private final Path path = Paths.get("uploads");
    private final AnnouncementService announcementService;
    private final CarImageRepository carImageRepository;

    public String save(MultipartFile file) {
        try {
            if(!Files.exists(path)){
                Files.createDirectory(path);
            }
            String newNameImage = UUID.randomUUID().toString();
            Path newName = path.resolve(newNameImage);
            Files.copy(file.getInputStream(), newName);
            return newNameImage;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void delete(Long id) {
        CarImage carImage = carImageRepository.findById(id).get();
        carImageRepository.delete(carImage);
    }


    public Resource load(String filename) {
        try {
            Path file = path.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public List<CarImage> findAll(Long id) {
        Announcement announcementEntity = announcementService.getAnnouncementEntity(id);
        Optional<List<CarImage>> byAnnouncement = carImageRepository.findByAnnouncement(announcementEntity);
        if (byAnnouncement.isPresent()) {
            return byAnnouncement.get();
        } else {
            throw new IllegalArgumentException("The Car Image with such id doesn't exist");
        }
    }
}
