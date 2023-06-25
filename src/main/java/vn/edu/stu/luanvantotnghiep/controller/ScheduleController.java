package vn.edu.stu.luanvantotnghiep.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import vn.edu.stu.luanvantotnghiep.model.DashBoard;
import vn.edu.stu.luanvantotnghiep.repository.DashBoardRepository;
import vn.edu.stu.luanvantotnghiep.service.ICustomerService;
import vn.edu.stu.luanvantotnghiep.service.IHoaDonService;
import vn.edu.stu.luanvantotnghiep.service.IKhuyenMaiService;
import vn.edu.stu.luanvantotnghiep.service.ILoaiSanPhamService;
import vn.edu.stu.luanvantotnghiep.service.INhaCungCapService;
import vn.edu.stu.luanvantotnghiep.service.INhaSanXuatService;
import vn.edu.stu.luanvantotnghiep.service.ISanPhamService;

@Configuration
@EnableScheduling
public class ScheduleController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ISanPhamService sanPhamService;
    @Autowired
    private IHoaDonService hoaDonService;
    @Autowired
    private ILoaiSanPhamService loaiSanPhamService;
    @Autowired
    private IKhuyenMaiService khuyenMaiService;
    @Autowired
    private INhaCungCapService nhaCungCapService;
    @Autowired
    private INhaSanXuatService nhaSanXuatService;
    @Autowired
    private DashBoardRepository dashBoardRepository;
    @Scheduled(cron = "59 23 * * * ?")
    public void scheduleFixedDelayTask() {
        Integer countUser = customerService.countCus();
        Integer countDonHang = hoaDonService.countHoaDon();
        Integer countSanPham = sanPhamService.countSanPham();
        Integer countLoaiSanPham = loaiSanPhamService.countLoaiSanPham();
        Integer countKhuyenMai = khuyenMaiService.countKhuyenMai();
        Integer countNhaCungCap = nhaCungCapService.countNhaCungCap();
        Integer countNhaSanXuat = nhaSanXuatService.countNhaSanXuat();
        Date dateCreate = Calendar.getInstance().getTime();
        String trangThai = "Complete";
        DashBoard dashBoard = new DashBoard(countUser, countDonHang, countSanPham, countLoaiSanPham, countKhuyenMai, countNhaCungCap, countNhaSanXuat, dateCreate, trangThai);
        dashBoardRepository.save(dashBoard);
    }
}
