package vn.edu.stu.luanvantotnghiep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.stu.luanvantotnghiep.model.NhaCungCap;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Integer>{
    Integer countByActive(Integer active);
}
