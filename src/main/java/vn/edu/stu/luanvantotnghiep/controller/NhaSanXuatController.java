package vn.edu.stu.luanvantotnghiep.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.model.NhaSanXuat;
import vn.edu.stu.luanvantotnghiep.service.INhaSanXuatService;

@RestController
@CrossOrigin(maxAge = 3600)
public class NhaSanXuatController {
    @Autowired
    private INhaSanXuatService nhaSanXuatService;

    @GetMapping("/nhasanxuat")
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findAllNhaSanXuat(){
        List<NhaSanXuat> lst = nhaSanXuatService.findAll();
        if (lst.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Không có dữ liệu cho nhà sản xuất");
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
    @GetMapping("/nhasanxuat/{id}")
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findNhaSanXuatByID(@PathVariable("id") Integer id){
        Optional<NhaSanXuat> nhaSanXuat = nhaSanXuatService.findById(id);
        if (nhaSanXuat.isPresent()) {
            FormatApi result = new FormatApi();
            result.setData(nhaSanXuat.get());
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(nhaSanXuat.get());
            result.setMessage("Không có dữ liệu cho nhà sản xuất có id = " + id);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @PostMapping("/nhasanxuat")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi createNhacungcap(@RequestBody NhaSanXuat nhaSanXuat){
        NhaSanXuat result = new NhaSanXuat();
        result.setMoTa(nhaSanXuat.getMoTa());
        result.setTenNhaSanXuat(nhaSanXuat.getTenNhaSanXuat());
        NhaSanXuat save = nhaSanXuatService.create(result);
        if(save != null){
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Tạo nhà sản xuất không thành công!");
            format.setStatus(HttpStatus.BAD_REQUEST);
            return format;
        }
    }
    @PutMapping("/nhasanxuat/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi updateNhacungcap(@PathVariable("id") Integer id, @RequestBody NhaSanXuat nhaSanXuat){
        NhaSanXuat save = nhaSanXuatService.update(id, nhaSanXuat);
        if(save != null){
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa nhà sản xuất có id = "+ nhaSanXuat.getId() +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        } else{
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa nhà sản xuất có id =" + nhaSanXuat.getId() +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
    @DeleteMapping("/nhasanxuat/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi deleteNhacungcap(@PathVariable("id") Integer id){
        NhaSanXuat delete = nhaSanXuatService.delete(id);
        if(delete != null){
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa nhà sản xuất có id ="+ id +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa nhà sản xuất có id ="+ id +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
}
