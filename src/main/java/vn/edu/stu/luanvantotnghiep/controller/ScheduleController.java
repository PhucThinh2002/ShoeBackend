package vn.edu.stu.luanvantotnghiep.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.stu.luanvantotnghiep.model.DashBoard;
import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.model.FormatApiDashBoard;
import vn.edu.stu.luanvantotnghiep.model.HoaDon;
import vn.edu.stu.luanvantotnghiep.model.ModelDataChartPie;
import vn.edu.stu.luanvantotnghiep.model.NhaSanXuat;
import vn.edu.stu.luanvantotnghiep.service.IDashBoardService;
import vn.edu.stu.luanvantotnghiep.service.IHoaDonService;
import vn.edu.stu.luanvantotnghiep.service.INhaSanXuatService;
import vn.edu.stu.luanvantotnghiep.service.ISanPhamService;

@Configuration
@EnableScheduling
@RestController
@CrossOrigin(maxAge = 3600)
public class ScheduleController {
    
    @Autowired
    private IDashBoardService dashBoardService;
    @Autowired
    private IHoaDonService hoaDonService;
    @Autowired
    private ISanPhamService sanPhamService;
    @Autowired
    private INhaSanXuatService nhaSanXuatService;

    @Scheduled(cron = "00 59 23 * * ?")
    public void scheduleFixedDelayTask() {
        dashBoardService.scheduleEveryDay();
    }

    @GetMapping("/dashboard")
    public FormatApi getDataDashBoardBeforeDate(){
        DashBoard dashBoard = dashBoardService.findByDateBefore();
        return new FormatApi(HttpStatus.OK, "Lấy dữ liệu dashboard thành công!", dashBoard);
    }

    @GetMapping("/dashboardtoday")
    public FormatApiDashBoard getDataDashBoardToDay(){
        DashBoard dashBoard = dashBoardService.getValueInDateNow();
        List<HoaDon> hoaDon = new ArrayList<>();
        hoaDon = hoaDonService.find10HoaDons();
        List<ModelDataChartPie> chartPie = new ArrayList<>();
        List<NhaSanXuat> nhaSanXuats = nhaSanXuatService.findAll();
        for(NhaSanXuat nsx : nhaSanXuats){
            ModelDataChartPie cP = new ModelDataChartPie();
            cP.setLabel(nsx.getTenNhaSanXuat());
            Integer soSanPham = sanPhamService.countSPByNhaSanXuat(nsx);
            Integer value = soSanPham == null ? 0 : soSanPham;
            cP.setValue(value);
            chartPie.add(cP);
        }
        return new FormatApiDashBoard(HttpStatus.OK, "Lấy dữ liệu dashboard thành công!", dashBoard, hoaDon, chartPie);
    }
}
