package vn.edu.stu.luanvantotnghiep.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vn.edu.stu.luanvantotnghiep.model.HinhAnh;
import vn.edu.stu.luanvantotnghiep.model.SanPham;
import vn.edu.stu.luanvantotnghiep.repository.HinhAnhRepository;
import vn.edu.stu.luanvantotnghiep.repository.SanPhamRepository;

@RestController
@CrossOrigin(maxAge = 33600)
public class HinhAnhController {
    @Autowired
    private HinhAnhRepository hinhAnhRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @PostMapping("/hinhanh")
    public HinhAnh createHinhAnh(@RequestParam MultipartFile hinhAnh) throws IOException {
        HinhAnh save = new HinhAnh();
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(hinhAnh.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(hinhAnh.getBytes());
        }
        save.setKichThuoc(hinhAnh.getSize());
        save.setPath(imagePath.resolve(hinhAnh.getOriginalFilename()).toString());
        save.setTenHinhAnh(hinhAnh.getOriginalFilename());
        save = hinhAnhRepository.save(save);
        return save;
    }
    @Autowired
    private FileStorageConfig fileStorageConfig;

    @PostMapping("/image")
    public ResponseEntity<HinhAnh> uploadImage(@RequestParam("hinhAnh") MultipartFile hinhAnh) throws IOException {
        String uploadDir = fileStorageConfig.getUploadDir();
        File directory = new File(uploadDir);

        if (!directory.exists()) {
            directory.mkdir();
        }
        Path filePath = Path.of(uploadDir, hinhAnh.getOriginalFilename());
        Files.copy(hinhAnh.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        HinhAnh save = new HinhAnh();
        save.setKichThuoc(hinhAnh.getSize());
        save.setPath(uploadDir);
        save.setTenHinhAnh(hinhAnh.getOriginalFilename());
        save = hinhAnhRepository.save(save);

        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) throws IOException {
        String uploadDir = fileStorageConfig.getUploadDir();
        Path imagePath = Path.of(uploadDir, filename);

        if (Files.exists(imagePath)) {
            byte[] imageBytes = Files.readAllBytes(imagePath);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/uploadanh")
    public String uploadImage2(@RequestParam("hinhAnh") MultipartFile file) {
        try {
            // Lưu trữ file vào thư mục "images"
            String fileName = file.getOriginalFilename();
            String filePath = Paths.get("images", fileName).toString();
            file.transferTo(new File(filePath));
            
            return "Upload thành công: " + fileName;
        } catch (IOException e) {
            return "Upload thất bại: " + e.getMessage();
        }
    }
    @PostMapping("/setimagetoproduct")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public HinhAnh setImageToProduct(@RequestParam Integer hinhAnh, @RequestParam Integer sanPham) {
        Optional<SanPham> find = sanPhamRepository.findById(sanPham);
        Optional<HinhAnh> findAnh = hinhAnhRepository.findById(hinhAnh);
        findAnh.get().setSanPham(find.get());
        return hinhAnhRepository.save(findAnh.get());
    }
}
