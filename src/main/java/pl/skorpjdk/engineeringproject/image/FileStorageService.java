package pl.skorpjdk.engineeringproject.image;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;


@Service
public class FileStorageService {

    private final Path path = Paths.get("uploads");

    public String save(MultipartFile file) {
        try {
            if(!Files.exists(path)){
                Files.createDirectory(path);
            }
            Path newName = path.resolve(UUID.randomUUID().toString());
            Files.copy(file.getInputStream(), newName);
            Optional<String> type = getType(newName);
            return newName.toUri() + "." + type;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    private Optional<String> getType(Path newName) {
        return Optional.of(newName.toString())
                .filter(f -> f.contains("."))
                .map(f -> f.substring(newName.toString().lastIndexOf(".") + 1));
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
}
