package vn.edu.vlu.khoaluan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.vlu.khoaluan.model.FormatApi;
import vn.edu.vlu.khoaluan.model.Size;
import vn.edu.vlu.khoaluan.repository.SizeRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(maxAge = 3600)
public class SizeController {
    @Autowired
    private SizeRepository sizeRepository;
    @GetMapping("/size")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findAllBaiViet() {
        List<Size> lst = sizeRepository.findAll();
        if (!lst.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lst);
            result.setMessage("Không có dữ liệu!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
    }
    @GetMapping("/size/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findSizeById(@PathVariable("id") Integer id) {
        Optional<Size> lst = sizeRepository.findById(id);
        if (lst.isPresent()) {
            FormatApi result = new FormatApi();
            result.setData(lst.get());
            result.setMessage("Không có dữ liệu cho size");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lst.get());
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
    }
    @PostMapping("/size")
    public Size createSize(@RequestBody Size size) {
        return sizeRepository.save(size);
    }
    @PutMapping("/size/{id}")
    public FormatApi updateSize(@PathVariable Integer id, @RequestBody Size sizeDetails) {
        Size size = sizeRepository.findById(id).get();
        if(size == null){
            FormatApi result = new FormatApi();
            result.setData(size);
            result.setMessage("Không có dữ liệu cho size");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            Size entity = sizeRepository.saveAndFlush(sizeDetails);
            FormatApi result = new FormatApi();
            result.setData(entity);
            result.setMessage("Thành công");
            result.setStatus(HttpStatus.OK);
            return result;
        }
    }
    @DeleteMapping("/size/{id}")
    public FormatApi deleteSize(@PathVariable Integer id) {
        if (sizeRepository.existsById(id)) {
            sizeRepository.deleteById(id);
            FormatApi result = new FormatApi();
            result.setData(null);
            result.setMessage("Thành công");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(null);
            result.setMessage("Không có dữ liệu cho size");
            result.setStatus(HttpStatus.OK);
            return result;
        }
    }
    
}
