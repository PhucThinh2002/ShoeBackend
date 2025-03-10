package vn.edu.vlu.khoaluan.controller;

import java.text.SimpleDateFormat;
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

import vn.edu.vlu.khoaluan.model.ChiTietPhieuNhapHang;
import vn.edu.vlu.khoaluan.model.Customer;
import vn.edu.vlu.khoaluan.model.FormatApi;
import vn.edu.vlu.khoaluan.model.ModelPhieuNhapHang;
import vn.edu.vlu.khoaluan.model.NhaCungCap;
import vn.edu.vlu.khoaluan.model.PhieuNhapHang;
import vn.edu.vlu.khoaluan.model.SanPham;
import vn.edu.vlu.khoaluan.service.IChiTietPhieuNhapHangService;
import vn.edu.vlu.khoaluan.service.ICustomerService;
import vn.edu.vlu.khoaluan.service.INhaCungCapService;
import vn.edu.vlu.khoaluan.service.IPhieuNhapHangService;
import vn.edu.vlu.khoaluan.service.ISanPhamService;

@RestController
@CrossOrigin(maxAge = 3600)
public class PhieuNhapHangController {
    @Autowired
    private IPhieuNhapHangService phieuNhapHangService;
    @Autowired
    private INhaCungCapService nhaCungCapService;
    @Autowired
    private ISanPhamService sanPhamService;
    @Autowired
    private IChiTietPhieuNhapHangService chiTietPhieuNhapHangService;
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/phieunhaphang")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findAllNhacungcap(){
        List<PhieuNhapHang> lst = phieuNhapHangService.findAll();
        if (lst.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Không có dữ liệu cho phiếu nhập hàng");
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
    @GetMapping("/phieunhaphang/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi finNhacungcapByID(@PathVariable("id") Integer id) {
        Optional<PhieuNhapHang> data = phieuNhapHangService.findById(id);
        if (data.isPresent()) {
            FormatApi result = new FormatApi();
            result.setData(data);
            result.setMessage("Không có dữ liệu cho bài viết có id = " + id);
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(data);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
    }
    @PostMapping("/phieunhaphang")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi createNhacungcap(@RequestBody ModelPhieuNhapHang phieuNhapHang){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()){
            FormatApi result = new FormatApi();
            result.setMessage("No Authentication user not found!");
            result.setStatus(HttpStatus.NOT_FOUND);
            return result;
        }
        Customer cusResult = customerService.findCustomerByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        PhieuNhapHang result = new PhieuNhapHang();
        Optional<NhaCungCap> nhaCungCap = nhaCungCapService.findById(phieuNhapHang.getNhaCungCap());
        result.setNhaCungCap(nhaCungCap.get());
        result.setTongTien(phieuNhapHang.getTongTien());
        result.setCreateDate(Calendar.getInstance().getTime());
        result.setActive(1);
        result.setQuanLy(cusResult);
        PhieuNhapHang save = phieuNhapHangService.create(result);
        for(ChiTietPhieuNhapHang c : phieuNhapHang.getChiTietPhieuNhapHang()){
            c.setPhieuNhapHang(save);
            String pattern = "yyyyMMddHHmmss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            int leght = save.getNhaCungCap().getTenNhaCungCap().length();
            c.setSeri(save.getNhaCungCap().getTenNhaCungCap().substring(0, leght > 5 ? leght : 5) + "_" + simpleDateFormat.format(Calendar.getInstance().getTime()));
            Optional<SanPham> sanPham = sanPhamService.findById(c.getSanPham().getId());
            c.setSanPham(sanPham.get());
            c = chiTietPhieuNhapHangService.create(c);
            sanPham.get().setSoLuongTon(sanPham.get().getSoLuongTon() + c.getSoLuong());
            sanPhamService.update(sanPham.get());
        }
        if(save != null){
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Tạo phiếu nhập hàng không thành công!");
            format.setStatus(HttpStatus.BAD_REQUEST);
            return format;
        }
    }
    @PutMapping("/phieunhaphang/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi updateNhacungcap(@PathVariable("id") Integer id, @RequestBody PhieuNhapHang phieuNhapHang){
        Optional<PhieuNhapHang> data = phieuNhapHangService.findById(id);
        if(data.isPresent()){
            Optional<NhaCungCap> nhaCungCap = nhaCungCapService.findById(phieuNhapHang.getNhaCungCap().getId());
            data.get().setNhaCungCap(nhaCungCap.get());
            data.get().setChiTietPhieuNhapHang(phieuNhapHang.getChiTietPhieuNhapHang());
            data.get().setTongTien(phieuNhapHang.getTongTien());
            PhieuNhapHang save = phieuNhapHangService.update(data.get());
            FormatApi format = new FormatApi();
            format.setData(save);
            format.setMessage("Sửa phiếu nhập hàng có id ="+ phieuNhapHang.getId() +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        } else{
            FormatApi format = new FormatApi();
            format.setData(data);
            format.setMessage("Sửa phiếu nhập hàng có id ="+ phieuNhapHang.getId() +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
    @DeleteMapping("/phieunhaphang/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi deleteNhacungcap(@PathVariable("id") Integer id){
        PhieuNhapHang delete = phieuNhapHangService.delete(id);
        if(delete != null){
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa phiếu nhập hàng có id ="+ id +" thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }else{
            FormatApi format = new FormatApi();
            format.setData(null);
            format.setMessage("Xóa phiếu nhập hàng có id ="+ id +" không thành công!");
            format.setStatus(HttpStatus.OK);
            return format;
        }
    }
}
