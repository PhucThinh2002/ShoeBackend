package vn.edu.stu.luanvantotnghiep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.stu.luanvantotnghiep.model.LoaiSanPham;

public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, Integer>{
    Integer countByActive(Integer active);
}
