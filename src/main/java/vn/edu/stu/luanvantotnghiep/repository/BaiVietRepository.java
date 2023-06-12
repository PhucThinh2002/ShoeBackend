package vn.edu.stu.luanvantotnghiep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.edu.stu.luanvantotnghiep.model.BaiViet;

public interface BaiVietRepository extends JpaRepository<BaiViet, Integer>{
    @Query(value = "SELECT * FROM bai_viet where active = 1", nativeQuery = true)
    List<BaiViet> findAllBaiVietActive();
}
