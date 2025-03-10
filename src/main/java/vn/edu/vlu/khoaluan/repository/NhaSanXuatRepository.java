package vn.edu.vlu.khoaluan.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.vlu.khoaluan.model.NhaSanXuat;

public interface NhaSanXuatRepository extends JpaRepository<NhaSanXuat, Integer>{
    Integer countByActive(Integer active);
    Integer countByActiveAndCreateDate(Integer active, Date createDate);
    NhaSanXuat findByTenNhaSanXuat(String name);
}
