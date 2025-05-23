package vn.edu.vlu.khoaluan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.vlu.khoaluan.model.BaiViet;

public interface BaiVietRepository extends JpaRepository<BaiViet, Integer>{
    List<BaiViet> findByActive(Integer active);
}
    