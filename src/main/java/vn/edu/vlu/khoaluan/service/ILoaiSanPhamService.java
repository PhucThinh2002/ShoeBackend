package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.LoaiSanPham;

public interface ILoaiSanPhamService {
    List<LoaiSanPham> findAll();
    Optional<LoaiSanPham> findById(Integer id);
    LoaiSanPham create(LoaiSanPham loaiSanPham);
    LoaiSanPham update(Integer id, LoaiSanPham loaiSanPham);
    LoaiSanPham delete(Integer id);
    Integer countLoaiSanPham();
    LoaiSanPham findByName(String name);
}
