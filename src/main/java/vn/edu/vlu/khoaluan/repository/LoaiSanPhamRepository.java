package vn.edu.vlu.khoaluan.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.vlu.khoaluan.model.LoaiSanPham;

public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, Integer>{
    List<LoaiSanPham>findByActive(Integer active);
    Integer countByActive(Integer active);
    Integer countByActiveAndCreateDate(Integer active,Date createDate);
    LoaiSanPham findByTenDanhMucAndActive(String name, Integer active);
}
