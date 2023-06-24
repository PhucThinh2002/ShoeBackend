package vn.edu.stu.luanvantotnghiep.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.stu.luanvantotnghiep.model.Banner;
import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.model.HinhAnh;
import vn.edu.stu.luanvantotnghiep.service.IBannerService;
import vn.edu.stu.luanvantotnghiep.service.IHinhAnhService;

@RestController
@CrossOrigin(maxAge = 3600)
public class BannerController {
    @Autowired
    private IBannerService bannerService;
    @Autowired
    private IHinhAnhService hinhAnhRepository;
    @GetMapping("/banner")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findAll(){
        List<Banner> lst = bannerService.findAll();
        if (lst.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Không có dữ liệu cho bài viết");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
    }
    @GetMapping("/banneractive")
    public FormatApi findAllActive(){
        List<Banner> lst = bannerService.findAllByActive();
        if (lst.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Không có dữ liệu cho bài viết");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
    }
    @GetMapping("/banner/{id}")
    public FormatApi findBaiVietByID(@PathVariable("id") Integer id) {
        Optional<Banner> data = bannerService.findById(id);
        if (data.isPresent()) {
            FormatApi result = new FormatApi();
            result.setData(data);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(data);
            result.setMessage("Không có dữ liệu cho banner có id = " + id);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @PostMapping("/banner")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi createBaiViet(@RequestBody Banner banner) {
        Banner data = new Banner();
        data.setTen(banner.getTen());
        data.setCreateDate(Calendar.getInstance().getTime());
        data.setActive(1);
        Banner save = bannerService.create(data);
        if(save != null){
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Tạo banner không thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
        
    }
    @PutMapping("/banner/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi UpdateBaiViet(@PathVariable("id") Integer id, @RequestBody Banner banner) {
        Banner save = bannerService.update(id,banner);
        if(save != null){
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Sửa banner không thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
        
    }
    @DeleteMapping("/banner/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi deleteLoaiSanPham(@PathVariable("id") Integer id){
        Banner delete = bannerService.delete(id);
        if(delete != null){
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa banner có id ="+ id +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa banner có id ="+ id +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
    @PostMapping("/setimagetobanner")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi setImageToBanner(@RequestParam("hinhAnh") Integer hinhAnh, @RequestParam("banner") Integer banner){
        Optional<Banner> dataB = bannerService.findById(banner);
        Optional<HinhAnh> dataH = hinhAnhRepository.findById(hinhAnh);
        dataH.get().setBanner(dataB.get());
        HinhAnh save = hinhAnhRepository.update(dataH.get());
        if(save != null){
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
}
