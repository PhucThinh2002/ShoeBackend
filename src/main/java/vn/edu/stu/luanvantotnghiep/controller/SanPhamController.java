package vn.edu.stu.luanvantotnghiep.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.model.FormatApiSanPham;
import vn.edu.stu.luanvantotnghiep.model.KhuyenMai;
import vn.edu.stu.luanvantotnghiep.model.LoaiSanPham;
import vn.edu.stu.luanvantotnghiep.model.ModelSanPham;
import vn.edu.stu.luanvantotnghiep.model.NhaSanXuat;
import vn.edu.stu.luanvantotnghiep.model.SanPham;
import vn.edu.stu.luanvantotnghiep.service.IKhuyenMaiService;
import vn.edu.stu.luanvantotnghiep.service.ILoaiSanPhamService;
import vn.edu.stu.luanvantotnghiep.service.INhaSanXuatService;
import vn.edu.stu.luanvantotnghiep.service.ISanPhamService;

@RestController
@CrossOrigin(maxAge = 3600)
public class SanPhamController {
    @Autowired
    private ISanPhamService sanPhamService;
    @Autowired
    private ILoaiSanPhamService loaiSanPhamService;
    @Autowired
    private INhaSanXuatService nhaSanXuatService;
    @Autowired
    private IKhuyenMaiService khuyenMaiService;

    @GetMapping("/sanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findAllSanPham(@RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(defaultValue = "10") Integer currentpage) {
        Page<SanPham> lstSanPham = sanPhamService.findAll(limit, currentpage);
        if (lstSanPham.getSize() > 0) {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Không có dữ liệu sản phẩm!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }

    @GetMapping("/sanpham/{id}")
    public FormatApi findSanPhamByID(@PathVariable("id") Integer id) {
        Optional<SanPham> sanPham = sanPhamService.findById(id);
        if (sanPham.isPresent()) {
            if (sanPham.get().getTrangThai() == 1) {
                FormatApi result = new FormatApi();
                result.setData(sanPham);
                result.setMessage("Thành công!");
                result.setStatus(HttpStatus.OK);
                return result;
            } else {
                FormatApi result = new FormatApi();
                result.setData(null);
                result.setMessage("Không có dữ liệu sản phẩm có id = " + id);
                result.setStatus(HttpStatus.NO_CONTENT);
                return result;
            }
        } else {
            FormatApi result = new FormatApi();
            result.setData(null);
            result.setMessage("Không có dữ liệu sản phẩm có id = " + id);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }

    @GetMapping("/sanpham/nhasanxuat/{tenHangSanXuat}")
    public FormatApi findSanPhamByNhaSanXuat(@PathVariable("tenHangSanXuat") String tenHangSanXuat) {
        NhaSanXuat nhaSanXuat = nhaSanXuatService.findByTenNhaSanXuat(tenHangSanXuat);
        if (nhaSanXuat == null) {
            FormatApi result = new FormatApi();
            result.setData(nhaSanXuat);
            result.setMessage("Không có dữ liệu sản phẩm của nhà sản xuất có tên = " + tenHangSanXuat);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        } else {
            List<SanPham> lstSanPham = sanPhamService.findSanPhamByNhaSanXuatActive(nhaSanXuat.getId());
            if (!lstSanPham.isEmpty()) {
                FormatApi result = new FormatApi();
                result.setData(lstSanPham);
                result.setMessage("Thành công!");
                result.setStatus(HttpStatus.OK);
                return result;
            } else {
                FormatApi result = new FormatApi();
                result.setData(lstSanPham);
                result.setMessage("Không có dữ liệu sản phẩm của nhà sản xuất có tên = " + tenHangSanXuat);
                result.setStatus(HttpStatus.NO_CONTENT);
                return result;
            }
        }

    }

    @GetMapping("/sanpham/loaisanpham/{tenLoaiSanPham}")
    public FormatApi findSanPhamByLoaiSanPham(@PathVariable("tenLoaiSanPham") String tenLoaiSanPham) {
        LoaiSanPham loaiSanPham = loaiSanPhamService.findByName(tenLoaiSanPham);
        List<SanPham> lstSanPham = sanPhamService.findByLoaiSanPhamAndTrangThai(loaiSanPham, 1);
        if (!lstSanPham.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Không có dữ liệu sản phẩm của loại sản phẩm có tên = " + tenLoaiSanPham);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }

    @GetMapping("/sanphamactive")
    public FormatApiSanPham findSanPhamActive(@RequestParam(defaultValue = "10") Integer currentpage,
            @RequestParam(defaultValue = "10") Integer limit) {
        Page<SanPham> lstSanPham = sanPhamService.findSanPhamActive(limit, currentpage);
        if (lstSanPham.getSize() > 0) {
            FormatApiSanPham result = new FormatApiSanPham();
            result.setData(lstSanPham.getContent());
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            result.setCurrentpage(currentpage);
            result.setTotalPage(lstSanPham.getTotalPages());
            return result;
        } else {
            FormatApiSanPham result = new FormatApiSanPham();
            result.setData(lstSanPham.getContent());
            result.setMessage("Không có dữ liệu sản phẩm");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }

    @PostMapping("/sanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi createSanPham(@RequestBody ModelSanPham sanPham) {
        SanPham data = new SanPham();
        data.setTenSanPham(sanPham.getTenSanPham());
        data.setGia(sanPham.getGia());
        data.setMoTa(sanPham.getMoTa());
        data.setSoLuongTon(sanPham.getSoLuongTon());
        data.setBaoHanh(sanPham.getBaoHanh());
        data.setThuocTinhs(sanPham.getThuocTinhs());
        data.setNamRaMat(sanPham.getNamRaMat());
        SanPham save = sanPhamService.create(data);
        save = setDanhMucToSanPham(save.getId(), sanPham.getDanhMuc().getId());
        save = setNhaSanXuatToSanPham(save.getId(), sanPham.getNhaSanXuat().getId());
        if (save != null) {
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Tạo sản phẩm không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }

    @PostMapping("/setdanhmuctosanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public SanPham setDanhMucToSanPham(@RequestParam("sanPham") Integer sanPham,
            @RequestParam("danhMuc") Integer danhMuc) {
        Optional<SanPham> dataSanPham = sanPhamService.findById(sanPham);
        Optional<LoaiSanPham> dataLoaiSanPham = loaiSanPhamService.findById(danhMuc);
        dataSanPham.get().setDanhMuc(dataLoaiSanPham.get());
        return sanPhamService.update(dataSanPham.get());
    }

    @PostMapping("/setnhasanxuattosanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public SanPham setNhaSanXuatToSanPham(@RequestParam("sanPham") Integer sanPham,
            @RequestParam("nhaSanXuat") Integer nhaSanXuat) {
        Optional<SanPham> dataSanPham = sanPhamService.findById(sanPham);
        Optional<NhaSanXuat> dataNhaSanXuat = nhaSanXuatService.findById(nhaSanXuat);
        dataSanPham.get().setNhaSanXuat(dataNhaSanXuat.get());
        return sanPhamService.update(dataSanPham.get());
    }

    @PostMapping("/setkhuyenmaitosanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public SanPham setKhuyenMaiToSanPham(@RequestParam("sanPham") Integer sanPham,
            @RequestParam("khuyenMai") Integer khuyenMai) {
        Optional<SanPham> dataSanPham = sanPhamService.findById(sanPham);
        Optional<KhuyenMai> dataKhuyenMai = khuyenMaiService.findById(khuyenMai);
        List<SanPham> lstS = dataKhuyenMai.get().getSanPham();
        List<KhuyenMai> lstK = dataSanPham.get().getKhuyenMais();
        lstS.add(dataSanPham.get());
        lstK.add(dataKhuyenMai.get());
        dataSanPham.get().setKhuyenMais(lstK);
        dataKhuyenMai.get().setSanPham(lstS);
        khuyenMaiService.update(dataKhuyenMai.get().getId(), dataKhuyenMai.get());
        return sanPhamService.update(dataSanPham.get());
    }
    @PutMapping("/sanpham/{id}")
    public FormatApi updateSanPham(@PathVariable("id") Integer id, @RequestBody SanPham sanPham){
        SanPham find = sanPhamService.findById(id).get();
        find.setBaoHanh(sanPham.getBaoHanh());
        find.setDanhMuc(sanPham.getDanhMuc());
        find.setGia(sanPham.getGia());
        find.setMoTa(sanPham.getMoTa());
        find.setNamRaMat(sanPham.getNamRaMat());
        find.setTenSanPham(sanPham.getTenSanPham());
        SanPham save = sanPhamService.update(find);
        if (save != null) {
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Sửa sản phẩm không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @DeleteMapping("/sanpham/delete/{id}")
    public FormatApi deleteSanPham(@PathVariable("id") Integer id){
        SanPham sanPham = sanPhamService.findById(id).get();
        if (sanPham != null) {
            sanPham.setTrangThai(0);
            sanPham = sanPhamService.update(sanPham);
            FormatApi result = new FormatApi();
            result.setData(sanPham);
            result.setMessage("Xóa sản phẩm có id = " + id +" thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(sanPham);
            result.setMessage("Xóa sản phẩm có id = " + id +" không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @PutMapping("/sanpham/active/{id}")
    public FormatApi activeSanPham(@PathVariable("id") Integer id){
        SanPham sanPham = sanPhamService.findById(id).get();
        sanPham.setTrangThai(1);
        sanPham = sanPhamService.update(sanPham);
        if (sanPham != null) {
            FormatApi result = new FormatApi();
            result.setData(sanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(sanPham);
            result.setMessage("Không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    
    
}
