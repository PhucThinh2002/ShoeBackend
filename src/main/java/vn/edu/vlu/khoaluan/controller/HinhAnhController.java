package vn.edu.vlu.khoaluan.controller;

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

import vn.edu.vlu.khoaluan.model.FormatApi;
import vn.edu.vlu.khoaluan.model.HinhAnh;
import vn.edu.vlu.khoaluan.model.SanPham;
import vn.edu.vlu.khoaluan.service.IHinhAnhService;
import vn.edu.vlu.khoaluan.service.ISanPhamService;

@RestController
@CrossOrigin(maxAge = 33600)
public class HinhAnhController {
    @Autowired
    private IHinhAnhService hinhAnhService;
    @Autowired
    private ISanPhamService sanPhamService;

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
        save = hinhAnhService.create(save);
        return save;
    }
    @Autowired
    private FileStorageConfig fileStorageConfig;

    @PostMapping("/image")
    public FormatApi uploadImage(@RequestParam("hinhAnh") MultipartFile hinhAnh) {
        String linkServer = "http://localhost:8080/getimage/";
        String uploadDir = fileStorageConfig.getUploadDir();
        File directory = new File(uploadDir);

        if (!directory.exists()) {
            directory.mkdir();
        }
        Path filePath = Path.of(uploadDir, hinhAnh.getOriginalFilename());
        try {
            Files.copy(hinhAnh.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HinhAnh save = new HinhAnh();
        save.setKichThuoc(hinhAnh.getSize());
        save.setTenHinhAnh(hinhAnh.getOriginalFilename());
        save.setPath(linkServer + hinhAnh.getOriginalFilename());
        save = hinhAnhService.create(save);

        return new FormatApi(HttpStatus.OK, "Thêm hình ảnh thành công", save);
    }

    @GetMapping("/getimage/{filename}")
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
        Optional<SanPham> find = sanPhamService.findById(sanPham);
        Optional<HinhAnh> findAnh = hinhAnhService.findById(hinhAnh);
        findAnh.get().setSanPham(find.get());
        return hinhAnhService.create(findAnh.get());
    }
}
