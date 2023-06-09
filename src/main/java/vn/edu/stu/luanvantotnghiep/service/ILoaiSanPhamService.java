package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.LoaiSanPham;

public interface ILoaiSanPhamService {
    List<LoaiSanPham> findAll();
    Optional<LoaiSanPham> findById(Integer id);
    LoaiSanPham create(LoaiSanPham loaiSanPham);
    LoaiSanPham update(Integer id, LoaiSanPham loaiSanPham);
    LoaiSanPham delete(Integer id);
}
