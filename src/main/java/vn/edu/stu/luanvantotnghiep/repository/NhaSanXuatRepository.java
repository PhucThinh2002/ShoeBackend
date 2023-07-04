package vn.edu.stu.luanvantotnghiep.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.stu.luanvantotnghiep.model.NhaSanXuat;

public interface NhaSanXuatRepository extends JpaRepository<NhaSanXuat, Integer>{
    Integer countByActive(Integer active);
    Integer countByActiveAndCreateDate(Integer active, Date createDate);
    NhaSanXuat findByTenNhaSanXuat(String name);
}
