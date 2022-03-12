package pl.skorpjdk.engineeringproject.image;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import pl.skorpjdk.engineeringproject.announcement.Announcement;
import pl.skorpjdk.engineeringproject.announcement.AnnouncementRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ImageController {

    private final FileStorageService storageService;
    private final CarImageRepository carImageRepository;
    private final AnnouncementRepository announcementRepository;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("announcementId") Long id) {
        String message = "";
        Optional<Announcement> announcement = announcementRepository.findById(id);
        CarImage carImage = new CarImage();
        try {
            String pathFile = storageService.save(file);

            announcement.ifPresentOrElse(carImage::setAnnouncement, () ->{throw new NullPointerException();});
            carImage.setUrl(pathFile);
            carImageRepository.save(carImage);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<CarImage>> getListFiles() {
        List<CarImage> all = carImageRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
