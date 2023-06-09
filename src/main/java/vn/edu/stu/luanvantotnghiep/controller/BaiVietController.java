package vn.edu.stu.luanvantotnghiep.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.stu.luanvantotnghiep.model.BaiViet;
import vn.edu.stu.luanvantotnghiep.model.Customer;
import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.repository.CustomerRepository;
import vn.edu.stu.luanvantotnghiep.service.IBaiVietService;

@RestController
@CrossOrigin(maxAge = 3600)
public class BaiVietController {
    @Autowired
    private IBaiVietService baiVietService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/baiviet")
    public FormatApi findAllBaiViet() {
        List<BaiViet> lst = baiVietService.findAll();
        if (!lst.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Không có dữ liệu cho bài viết");
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

    @GetMapping("/baiviet/{id}")
    public FormatApi findBaiVietByID(@PathVariable("id") Integer id) {
        Optional<BaiViet> data = baiVietService.findById(id);
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

    @PostMapping("/baiviet")
    public FormatApi createBaiViet(@RequestBody BaiViet baiViet) {
        Optional<Customer> quanLy = customerRepository.findCustomerByIdAndActivated(baiViet.getQuanLy().getId());
        BaiViet data = new BaiViet();
        data.setNoiDung(baiViet.getNoiDung());
        data.setTieuDe(baiViet.getTieuDe());
        data.setQuanLy(quanLy.get());
        data.setCreateDate(Calendar.getInstance().getTime());
        data.setActive(1);
        BaiViet crtBaiViet = baiVietService.create(data);
        if(crtBaiViet != null){
            FormatApi result = new FormatApi();
            result.setData(crtBaiViet);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            FormatApi result = new FormatApi();
            result.setData(crtBaiViet);
            result.setMessage("Tạo bài viết không thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
        
    }
    @PutMapping("/baiviet/{id}")
    public FormatApi UpdateBaiViet(@PathVariable("id") Integer id, @RequestBody BaiViet baiViet) {
        BaiViet crtBaiViet = baiVietService.update(id,baiViet);
        if(crtBaiViet != null){
            FormatApi result = new FormatApi();
            result.setData(crtBaiViet);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            FormatApi result = new FormatApi();
            result.setData(crtBaiViet);
            result.setMessage("Sửa bài viết không thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
        
    }
}
