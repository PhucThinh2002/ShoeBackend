package vn.edu.vlu.khoaluan.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.vlu.khoaluan.model.FormatApi;
import vn.edu.vlu.khoaluan.model.KhuyenMai;
import vn.edu.vlu.khoaluan.service.IKhuyenMaiService;

@RestController
@CrossOrigin(maxAge = 3600)
public class KhuyenMaiController {
    @Autowired
    private IKhuyenMaiService khuyenMaiService;
    @GetMapping("/khuyenmai")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findAllKhuyenMai() {
        List<KhuyenMai> lst = khuyenMaiService.findAll();
        if (lst.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Không có dữ liệu cho khuyến mãi");
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

    @GetMapping("/khuyenmai/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findKhuyenMaiByID(@PathVariable("id") Integer id) {
        Optional<KhuyenMai> data = khuyenMaiService.findById(id);
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
    @PostMapping("/khuyenmai")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi createKhuyenMai(@RequestBody KhuyenMai khuyenMai){
        KhuyenMai result = new KhuyenMai();
        result.setActive(1);
        result.setCreateDate(Calendar.getInstance().getTime());
        result.setDescription(khuyenMai.getDescription());
        result.setName(khuyenMai.getName());
        result.setPercentDiscount(khuyenMai.getPercentDiscount());
        result.setCloseDate(khuyenMai.getCloseDate());
        KhuyenMai save = khuyenMaiService.create(result);
        if(save != null){
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Tạo khuyến mãi không thành công!");
            format.setStatus(HttpStatus.BAD_REQUEST);
            return format;
        }
    }
    @PutMapping("/khuyenmai/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi updateKhuyenMai(@PathVariable("id") Integer id, @RequestBody KhuyenMai khuyenMai){
        KhuyenMai save = khuyenMaiService.update(id, khuyenMai);
        if(save != null){
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa loại sản phẩm có id = "+ id +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa loại sản phẩm có id = "+ id +" không thành công!");
            format.setStatus(HttpStatus.BAD_REQUEST);
            return format;
        }
    }
}
