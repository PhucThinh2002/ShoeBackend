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
import vn.edu.stu.luanvantotnghiep.model.LoaiSanPham;
import vn.edu.stu.luanvantotnghiep.service.ILoaiSanPhamService;

@RestController
@CrossOrigin(maxAge = 3600)
public class LoaiSanPhamController {
    @Autowired
    private ILoaiSanPhamService loaiSanPhamService;

    @GetMapping("/loaisanpham")
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findAllLoaiSanPham(){
        List<LoaiSanPham> lst = loaiSanPhamService.findAll();
        if (lst.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Không có dữ liệu cho loại sản phẩm");
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
    @GetMapping("/loaisanpham/{id}")
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi finLoaiSanPhamByID(@PathVariable("id") Integer id) {
        Optional<LoaiSanPham> data = loaiSanPhamService.findById(id);
        if (data.isPresent()) {
            FormatApi result = new FormatApi();
            result.setData(data);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(data);
            result.setMessage("Không có dữ liệu cho loại sản phẩm có id = " + id);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
            
        }
    }
    @PostMapping("/loaisanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi createLoaiSanPham(@RequestBody LoaiSanPham loaiSanPham){
        LoaiSanPham result = new LoaiSanPham();
        result.setTenDanhMuc(loaiSanPham.getTenDanhMuc());
        result.setMoTa(loaiSanPham.getMoTa());
        LoaiSanPham save = loaiSanPhamService.create(result);
        if(save != null){
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Tạo loại sản phẩm không thành công!");
            format.setStatus(HttpStatus.BAD_REQUEST);
            return format;
        }
    }
    @PutMapping("/loaisanpham/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi updateLoaiSanPham(@PathVariable("id") Integer id, @RequestBody LoaiSanPham loaiSanPham){
        LoaiSanPham save = loaiSanPhamService.update(id, loaiSanPham);
        // Optional<LoaiSanPham> data = loaiSanPhamService.findById(id);
        if(save != null){
            // data.get().setMoTa(loaiSanPham.getMoTa());
            // data.get().setTenDanhMuc(loaiSanPham.getTenDanhMuc());
            
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa loại sản phẩm có id ="+ loaiSanPham.getId() +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        } else{
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa loại sản phẩm có id ="+ loaiSanPham.getId() +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
    @PutMapping("/loaisanpham/active/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi updateLoaiSanPham(@PathVariable("id") Integer id){
        LoaiSanPham loaiSanPham = loaiSanPhamService.findById(id).get();
        loaiSanPham.setActive(1);
        LoaiSanPham save = loaiSanPhamService.update(id, loaiSanPham);
        // Optional<LoaiSanPham> data = loaiSanPhamService.findById(id);
        if(save != null){
            // data.get().setMoTa(loaiSanPham.getMoTa());
            // data.get().setTenDanhMuc(loaiSanPham.getTenDanhMuc());
            
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa loại sản phẩm có id ="+ loaiSanPham.getId() +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        } else{
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa loại sản phẩm có id ="+ loaiSanPham.getId() +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
    @DeleteMapping("/loaisanpham/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi deleteLoaiSanPham(@PathVariable("id") Integer id){
        LoaiSanPham delete = loaiSanPhamService.delete(id);
        if(delete != null){
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa loại sản phẩm có id ="+ id +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa loại sản phẩm có id ="+ id +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
}
