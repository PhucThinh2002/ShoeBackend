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
import vn.edu.stu.luanvantotnghiep.service.IDashBoardService;
import vn.edu.stu.luanvantotnghiep.service.IHoaDonService;

@Configuration
@EnableScheduling
@RestController
@CrossOrigin(maxAge = 3600)
public class ScheduleController {
    
    @Autowired
    private IDashBoardService dashBoardService;
    @Autowired
    private IHoaDonService hoaDonService;

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
        return new FormatApiDashBoard(HttpStatus.OK, "Lấy dữ liệu dashboard thành công!", dashBoard, hoaDon);
    }
}
