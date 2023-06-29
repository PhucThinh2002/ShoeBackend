package vn.edu.stu.luanvantotnghiep.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.stu.luanvantotnghiep.model.LoaiSanPham;

public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, Integer>{
    List<LoaiSanPham>findByActive(Integer active);
    Integer countByActive(Integer active);
    Integer countByActiveAndCreateDate(Integer active,Date createDate);
}
