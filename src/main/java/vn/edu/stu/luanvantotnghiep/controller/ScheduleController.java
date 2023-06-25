package vn.edu.stu.luanvantotnghiep.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import vn.edu.stu.luanvantotnghiep.model.DashBoard;
import vn.edu.stu.luanvantotnghiep.repository.CustomerRepository;
import vn.edu.stu.luanvantotnghiep.repository.DashBoardRepository;
import vn.edu.stu.luanvantotnghiep.repository.HoaDonRepository;
import vn.edu.stu.luanvantotnghiep.repository.KhuyenMaiRepository;
import vn.edu.stu.luanvantotnghiep.repository.LoaiSanPhamRepository;
import vn.edu.stu.luanvantotnghiep.repository.NhaCungCapRepository;
import vn.edu.stu.luanvantotnghiep.repository.NhaSanXuatRepository;
import vn.edu.stu.luanvantotnghiep.repository.SanPhamRepository;

@Configuration
@EnableScheduling
public class ScheduleController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;
    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;
    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;
    @Autowired
    private DashBoardRepository dashBoardRepository;
    @Scheduled(cron = "59 23 * * * ?")
    public void scheduleFixedDelayTask() {
        Integer countUser = customerRepository.countByActive(1);
        Integer countDonHang = hoaDonRepository.countByTrangThai(1);
        Integer countSanPham = sanPhamRepository.countByTrangThai(1);
        Integer countLoaiSanPham = loaiSanPhamRepository.countByActive(1);
        Integer countKhuyenMai = khuyenMaiRepository.countByActive(1);
        Integer countNhaCungCap = nhaCungCapRepository.countByActive(1);
        Integer countNhaSanXuat = nhaSanXuatRepository.countByActive(1);
        Date dateCreate = Calendar.getInstance().getTime();
        String trangThai = "Complete";
        DashBoard dashBoard = new DashBoard(countUser, countDonHang, countSanPham, countLoaiSanPham, countKhuyenMai, countNhaCungCap, countNhaSanXuat, dateCreate, trangThai);
        dashBoardRepository.save(dashBoard);
    }
}
