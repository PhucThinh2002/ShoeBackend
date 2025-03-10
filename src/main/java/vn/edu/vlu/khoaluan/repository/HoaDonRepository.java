package vn.edu.vlu.khoaluan.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.edu.vlu.khoaluan.model.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, Integer>{
    @Query(value = "select * from hoa_don where trang_thai = 1", nativeQuery = true)
    List<HoaDon> findAllHoaDonActive();
    @Query(value = "select * from hoa_don where khach_hang_id = :khachhang", nativeQuery = true)
    List<HoaDon> findAllHoaDonByKhachHang(@Param("khachhang") Integer khachHang);
    Integer countByTrangThai(Integer active);
    Integer countByTrangThaiAndCreateDate(Integer active, Date createDate);
    List<HoaDon> findFirst10ByTrangThaiOrderByCreateDateDesc(Integer active);
}
