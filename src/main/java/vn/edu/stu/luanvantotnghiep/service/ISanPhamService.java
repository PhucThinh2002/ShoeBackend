package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.SanPham;

public interface ISanPhamService {
    List<SanPham> findAll();
    Optional<SanPham> findById(Integer id);
    SanPham create(SanPham sanPham);
    SanPham update(SanPham sanPham);
    SanPham delete(Integer id);
}
