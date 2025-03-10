package vn.edu.vlu.khoaluan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.edu.vlu.khoaluan.model.Banner;

public interface BannerRepository extends JpaRepository<Banner, Integer>{
    @Query(value = "SELECT * FROM banner where trang_thai = 1", nativeQuery = true)
    List<Banner> findAllBannerActive();
}
