package vn.edu.stu.luanvantotnghiep.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.stu.luanvantotnghiep.model.BaiViet;
import vn.edu.stu.luanvantotnghiep.model.Customer;
import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.service.IBaiVietService;
import vn.edu.stu.luanvantotnghiep.service.ICustomerService;

@RestController
@CrossOrigin(maxAge = 3600)
public class BaiVietController {
    @Autowired
    private IBaiVietService baiVietService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/baiviet")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findAllBaiViet() {
        List<BaiViet> lst = baiVietService.findAll();
        if (!lst.isEmpty()) {
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
    @GetMapping("/baivietactive")
    public FormatApi findAllBaiVietActive() {
        List<BaiViet> lst = baiVietService.findAllActive();
        if (lst.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Không có dữ liệu cho bài viết");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
    }

    @GetMapping("/baiviet/{id}")
    public FormatApi findBaiVietByID(@PathVariable("id") Integer id) {
        Optional<BaiViet> data = baiVietService.findById(id);
        if (data.isPresent()) {
            FormatApi result = new FormatApi();
            result.setData(data);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(data);
            result.setMessage("Không có dữ liệu cho bài viết có id = " + id);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }

    @PostMapping("/baiviet")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi createBaiViet(@RequestBody BaiViet baiViet) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()){
            FormatApi result = new FormatApi();
            result.setMessage("No Authentication user not found!");
            result.setStatus(HttpStatus.NOT_FOUND);
            return result;
        }
        Customer cusResult = customerService.findCustomerByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        // Optional<Customer> quanLy = customerRepository.findCustomerByIdAndActivated(baiViet.getQuanLy().getId());
        BaiViet data = new BaiViet();
        data.setNoiDung(baiViet.getNoiDung());
        data.setTieuDe(baiViet.getTieuDe());
        data.setQuanLy(cusResult);
        data.setCreateDate(Calendar.getInstance().getTime());
        data.setActive(1);
        BaiViet crtBaiViet = baiVietService.create(data);
        if(crtBaiViet != null){
            FormatApi result = new FormatApi();
            result.setData(crtBaiViet);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            FormatApi result = new FormatApi();
            result.setData(crtBaiViet);
            result.setMessage("Tạo bài viết không thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
        
    }
    @PutMapping("/baiviet/{id}")
    public FormatApi UpdateBaiViet(@PathVariable("id") Integer id, @RequestBody BaiViet baiViet) {
        BaiViet crtBaiViet = baiVietService.update(id,baiViet);
        if(crtBaiViet != null){
            FormatApi result = new FormatApi();
            result.setData(crtBaiViet);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            FormatApi result = new FormatApi();
            result.setData(crtBaiViet);
            result.setMessage("Sửa bài viết không thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
        
    }
    @DeleteMapping("/baiviet/delete/{id}")
    public FormatApi deleteLBaiViet(@PathVariable("id") Integer id){
        BaiViet delete = baiVietService.delete(id);
        if(delete != null){
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa bài viết có id ="+ id +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa bài viết có id ="+ id +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
}
