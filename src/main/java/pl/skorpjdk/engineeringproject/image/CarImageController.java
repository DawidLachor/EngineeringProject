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

@Controller
@RequiredArgsConstructor
public class CarImageController {

    private final CarImageService storageService;
    private final CarImageRepository carImageRepository;
    private final AnnouncementRepository announcementRepository;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam(value = "announcementId", required = false) Long id) {
        String message = "";
        System.out.println("upload");
        Optional<Announcement> announcement = announcementRepository.findById(id);
        CarImage carImage = new CarImage();
        try {
            String imageName = storageService.save(file);
            String url = MvcUriComponentsBuilder.fromMethodName(CarImageController.class, "getFile", imageName).build().toString();

            announcement.ifPresentOrElse(carImage::setAnnouncement, () ->{throw new NullPointerException();});
            carImage.setUrl(url);
            carImage.setName(imageName);
            carImageRepository.save(carImage);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editFile(@RequestParam("file") MultipartFile file, @RequestParam(value = "announcementId", required = false) Long id) {
        String message = "";
        System.out.println("edit");
        Optional<Announcement> announcement = announcementRepository.findById(id);
        CarImage carImage = new CarImage();
        try {
            String imageName = storageService.save(file);
            String url = MvcUriComponentsBuilder.fromMethodName(CarImageController.class, "getFile", imageName).build().toString();

            announcement.ifPresentOrElse(carImage::setAnnouncement, () ->{throw new NullPointerException();});
            carImage.setUrl(url);
            carImage.setName(imageName);
            carImageRepository.save(carImage);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editFile(@PathVariable("id")  Long id) {
        String message = "";
        System.out.println("Delete");
        Announcement announcement = announcementRepository.findById(id).get();
        try {
            List<CarImage> byAnnouncement = carImageRepository.findByAnnouncement(announcement).get();
            carImageRepository.deleteAll(byAnnouncement);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/{id}/files")
    public ResponseEntity<List<CarImage>> getListFiles(@PathVariable Long id) {
        System.out.println("getall");
        List<CarImage> all = storageService.findAll(id);
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        System.out.println("get");
        Resource file = storageService.load(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
