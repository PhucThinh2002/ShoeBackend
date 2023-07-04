package vn.edu.stu.luanvantotnghiep.controller;

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
import org.springframework.web.bind.annotation.RestController;

import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.model.NhaCungCap;
import vn.edu.stu.luanvantotnghiep.service.INhaCungCapService;

@RestController
@CrossOrigin(maxAge = 3600)
public class NhaCungCapController {
    @Autowired
    private INhaCungCapService nhacungcapService;
    @GetMapping("/nhacungcap")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findAllNhacungcap(){
        List<NhaCungCap> lst = nhacungcapService.findAll();
        if (lst.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Không có dữ liệu cho nhà cung cấp");
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
    @GetMapping("/nhacungcap/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi finNhacungcapByID(@PathVariable("id") Integer id) {
        Optional<NhaCungCap> data = nhacungcapService.findById(id);
        if (data.isPresent()) {
            FormatApi result = new FormatApi();
            result.setData(data);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(data);
            result.setMessage("Không có dữ liệu cho nhà cung cấp có id = " + id);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @PostMapping("/nhacungcap")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi createNhacungcap(@RequestBody NhaCungCap nhaCungCap){
        NhaCungCap result = new NhaCungCap();
        result.setTenNhaCungCap(nhaCungCap.getTenNhaCungCap());
        result.setDiaChi(nhaCungCap.getDiaChi());
        result.setEmail(nhaCungCap.getEmail());
        result.setSoDienThoai(nhaCungCap.getSoDienThoai());
        NhaCungCap save = nhacungcapService.create(result);
        if(save != null){
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Tạo nhà cung cấp không thành công!");
            format.setStatus(HttpStatus.BAD_REQUEST);
            return format;
        }
    }
    @PutMapping("/nhacungcap/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi updateNhacungcap(@PathVariable("id") Integer id, @RequestBody NhaCungCap nhaCungCap){
        NhaCungCap save = nhacungcapService.update(id, nhaCungCap);
        if(save != null){
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa nhà cung cấp có id = "+ nhaCungCap.getId() +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        } else{
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa nhà cung cấp có id =" + nhaCungCap.getId() +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
    @PutMapping("/nhacungcap/active/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi activeNhaCungCap(@PathVariable("id") Integer id){
        NhaCungCap nhaCungCap = nhacungcapService.findById(id).get();
        nhaCungCap.setActive(1);
        NhaCungCap save = nhacungcapService.update(id, nhaCungCap);
        if(save != null){
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa nhà cung cấp có id = "+ nhaCungCap.getId() +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        } else{
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa nhà cung cấp có id =" + nhaCungCap.getId() +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
    @DeleteMapping("/nhacungcap/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi deleteNhacungcap(@PathVariable("id") Integer id){
        NhaCungCap delete = nhacungcapService.delete(id);
        if(delete != null){
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa nhà cung cấp có id ="+ id +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa nhà cung cấp có id ="+ id +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
}
