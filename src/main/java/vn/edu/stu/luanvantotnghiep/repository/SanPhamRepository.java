package vn.edu.stu.luanvantotnghiep.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.edu.stu.luanvantotnghiep.model.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer>{
    @Query(value = "select * from san_pham where trang_thai = 1 and danh_muc = :danhmuc", nativeQuery = true)
    List<SanPham> findSanPhamByDanhMucActive(@Param("danhmuc") Integer danhMuc);
    @Query(value = "select * from san_pham where trang_thai = 1 and nha_san_xuat = :nhasanxuat", nativeQuery = true)
    List<SanPham> findSanPhamByNhaSanXuatActive(@Param("nhasanxuat") Integer nhaSanXuat);
    @Query(value = "select * from san_pham where trang_thai = 1", nativeQuery = true)
    Page<SanPham> findSanPhamActive(PageRequest pageRequest);
    Integer countByTrangThai(Integer active);
}
