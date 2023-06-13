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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.stu.luanvantotnghiep.model.ChiTietHoaDon;
import vn.edu.stu.luanvantotnghiep.model.Customer;
import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.model.HoaDon;
import vn.edu.stu.luanvantotnghiep.model.ModelHoaDon;
import vn.edu.stu.luanvantotnghiep.model.SanPham;
import vn.edu.stu.luanvantotnghiep.model.TraGop;
import vn.edu.stu.luanvantotnghiep.repository.ChiTietHoaDonRepository;
import vn.edu.stu.luanvantotnghiep.repository.CustomerRepository;
import vn.edu.stu.luanvantotnghiep.repository.HoaDonRepository;
import vn.edu.stu.luanvantotnghiep.repository.SanPhamRepository;
import vn.edu.stu.luanvantotnghiep.repository.TraGopRepository;
import vn.edu.stu.luanvantotnghiep.service.IHoaDonService;

@RestController
@CrossOrigin(maxAge = 3600)
public class HoaDonController {
    @Autowired
    private IHoaDonService hoaDonService;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;
    @Autowired
    private TraGopRepository traGopRepository;

    @GetMapping("/hoadon")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public FormatApi findAllHoaDon(){
        List<HoaDon> lst = hoaDonService.findAll();
        if(!lst.isEmpty()){
            FormatApi format = new FormatApi(HttpStatus.OK, "Thành công", lst);
            return format;
        }else{
            FormatApi format = new FormatApi(HttpStatus.NO_CONTENT, "Không có dữ liệu hóa đơn!", lst);
            return format;
        }
    }
    @GetMapping("/hoadon/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public FormatApi findHoaDonByID(@PathVariable("id") Integer id) {
        Optional<HoaDon> data = hoaDonService.findById(id);
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
    @PostMapping("/hoadon")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public FormatApi createHoaDon(@RequestBody ModelHoaDon hoaDon){
        for(ChiTietHoaDon c : hoaDon.getChiTietHoaDons()){
            SanPham sanPham = sanPhamRepository.findById(c.getSanPham().getId()).get();
            if(sanPham.getSoLuongTon() == 0){
                FormatApi formatApi = new FormatApi(HttpStatus.NO_CONTENT, "Số lượng sản phẩm bạn muốn đặt đã hết, bạn hãy chọn sản phẩm khác nhé!", null);
                return formatApi;
            }else if(sanPham.getSoLuongTon() < c.getSoLuong()){
                FormatApi formatApi = new FormatApi(HttpStatus.OK, "Số lượng sản phẩm chỉ còn: " + sanPham.getSoLuongTon() + ". Bạn hãy chọn lại số lượng!", null);
                return formatApi;
            }
        }
        HoaDon save = new HoaDon();
        save.setCreateDate(Calendar.getInstance().getTime());
        save.setDiaChi(hoaDon.getDiaChi());
        save.setGhiChu(hoaDon.getGhiChu());
        save.setTenKhachHang(hoaDon.getTenKhachHang());
        save.setSoDienThoai(hoaDon.getSoDienThoai());
        save.setTrangThai(1);
        save.setTrangThaiThanhToan(0);
        save.setSoTienTraGop(hoaDon.getSoTienTraGop());
        save.setSoTienTraTruoc(hoaDon.getSoTienTraTruoc());
        if(hoaDon.getSoThangTraGop() > 0){
            save.setSoThangTraGop(hoaDon.getSoThangTraGop());
            save.setIsTraGop(true);
        }else{
            save.setSoThangTraGop(0);
            save.setIsTraGop(false);
        }
        Double tongTien = 0.0;
        for(ChiTietHoaDon c: hoaDon.getChiTietHoaDons()){
            tongTien += c.getGia() * c.getSoLuong();
        }
        save.setTongTien(tongTien);
        save = hoaDonService.create(save);
        int soThangTangDan = 1;
        Double soTienHangThang = (save.getSoTienTraGop() + (save.getSoTienTraGop() * 0.1)) / hoaDon.getSoThangTraGop();
        if(save.getSoThangTraGop() > 0){
            for(int i = 0; i < hoaDon.getSoThangTraGop(); i++){
                TraGop traGop = new TraGop();
                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();
                int year = cal1.get(Calendar.YEAR);
                int month = cal1.get(Calendar.MONTH) + 1;
                int day1 = 5;
                int day2 = 10;
                cal1.set(year, month + soThangTangDan, day1);
                cal2.set(year, month + soThangTangDan, day2);
                soThangTangDan ++;
                traGop.setDongTienTuNgay(cal1.getTime());
                traGop.setDongTienDenNgay(cal2.getTime());
                traGop.setDaBank(false);
                traGop.setHoaDon(save);
                traGop.setTrangThaiPhiPhat(0);
                traGop.setSoTienHangThang(soTienHangThang);
                traGop = traGopRepository.save(traGop);
            }
        }
        for(ChiTietHoaDon c : hoaDon.getChiTietHoaDons()){
            SanPham sanPham = sanPhamRepository.findById(c.getSanPham().getId()).get();
            c.setHoaDon(save);
            c.setSanPham(sanPham);
            c = chiTietHoaDonRepository.save(c);
            sanPham.setSoLuongTon(sanPham.getSoLuongTon() - c.getSoLuong());
            sanPhamRepository.save(sanPham);
        }
        if(save != null){
            FormatApi formatApi = new FormatApi(HttpStatus.OK, "Tạo hóa đơn thành công!", save);
            return formatApi;
        }else{
            FormatApi formatApi = new FormatApi(HttpStatus.INTERNAL_SERVER_ERROR, "Tạo hóa đơn không thành công!", save);
            return formatApi;
        }
    }
    @GetMapping("/hoadonbykhachhang")
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER')")
    public FormatApi findHoaDonByKhachHang(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()){
            FormatApi result = new FormatApi();
            result.setMessage("No Authentication user not found!");
            result.setStatus(HttpStatus.NOT_FOUND);
            return result;
        }
        Customer cusResult = customerRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<HoaDon> lstHoaDon = hoaDonRepository.findAllHoaDonByKhachHang(cusResult.getId());
        if(!lstHoaDon.isEmpty()){
            FormatApi formatApi = new FormatApi(HttpStatus.OK, "Bạn có hóa đơn", lstHoaDon);
            return formatApi;
        }else{
            FormatApi formatApi = new FormatApi(HttpStatus.NO_CONTENT, "Bạn chưa có hóa đơn nào!", lstHoaDon);
            return formatApi;
        }
    }
}
