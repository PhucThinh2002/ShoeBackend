package vn.edu.stu.luanvantotnghiep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.stu.luanvantotnghiep.model.BaiViet;

public interface BaiVietRepository extends JpaRepository<BaiViet, Integer>{
    List<BaiViet> findByActive(Integer active);
}
