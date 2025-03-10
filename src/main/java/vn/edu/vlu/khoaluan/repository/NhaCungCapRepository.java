package vn.edu.vlu.khoaluan.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.vlu.khoaluan.model.NhaCungCap;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Integer>{
    Integer countByActive(Integer active);
    Integer countByActiveAndCreateDate(Integer active, Date createDate);
}
