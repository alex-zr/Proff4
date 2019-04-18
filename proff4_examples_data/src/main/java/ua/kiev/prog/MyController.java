package ua.kiev.prog;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.kiev.prog.domain.Photo;
import ua.kiev.prog.repo.PhotoRepository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Controller
@AllArgsConstructor
public class MyController {
    private PhotoRepository photoRepository;

    @RequestMapping("/")
    public String onIndex() {
        return "index";
    }

    @RequestMapping(value = "/add_photo", method = RequestMethod.POST)
    public String onAddPhoto(Model model, @RequestParam MultipartFile photo) {
        if (photo.isEmpty()) {
            throw new PhotoErrorException("Photo is empty");
        }

        try {
            //ZipOutputStream zipOutputStream = new ZipOutputStream(new ByteArrayOutputStream());
            Photo photoEntity = photoRepository.save(new Photo(photo.getBytes()));

            model.addAttribute("photo_id", photoEntity.getId());
            return "result";
        } catch (IOException e) {
            throw new PhotoErrorException("Error");
        }
    }

    @RequestMapping("/photo/{photo_id}")
    public ResponseEntity<byte[]> onPhoto(@PathVariable("photo_id") long id) {
        return photoById(id);
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public ResponseEntity<byte[]> onView(@RequestParam("photo_id") long id) {
        return photoById(id);
    }

    @RequestMapping("/delete/{photo_id}")
    public String onDelete(@PathVariable("photo_id") long id) {
        Photo photo = photoRepository.findById(id)
                .orElseThrow(PhotoNotFoundException::new);
        photoRepository.delete(photo);

        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String error() {
        return "error";
    }

    private ResponseEntity<byte[]> photoById(long id) {
        byte[] bytes = photoRepository.findById(id)
                .orElseThrow(PhotoNotFoundException::new)
                .getImage();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}