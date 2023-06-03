package vn.edu.stu.luanvantotnghiep.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.stu.luanvantotnghiep.model.BaiViet;
import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.service.IBaiVietService;

@RestController
@CrossOrigin(maxAge = 3600)
public class BaiVietController {
    @Autowired
    private IBaiVietService baiVietService;

    @GetMapping("/baiviet")
    public FormatApi findAllBaiViet() {
        List<BaiViet> lst = baiVietService.findAll();
        if (lst.isEmpty()) {
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

    @PostMapping("/baiviet")
    public FormatApi createBaiViet(@RequestBody BaiViet baiViet) {
        BaiViet data = new BaiViet();
        data.setNoiDung(baiViet.getNoiDung());
        data.setTieuDe(baiViet.getTieuDe());
        data.setQuanLy(null);
        BaiViet crtBaiViet = baiVietService.create(baiViet);
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
}
