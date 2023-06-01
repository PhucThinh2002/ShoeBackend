package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.ChiTietPhieuNhapHang;

public interface IChiTietPhieuNhapHangService {
    List<ChiTietPhieuNhapHang> findAll();
    Optional<ChiTietPhieuNhapHang> findById(Integer id);
    ChiTietPhieuNhapHang create(ChiTietPhieuNhapHang chiTietPhieuNhapHang);
    ChiTietPhieuNhapHang update(ChiTietPhieuNhapHang chiTietPhieuNhapHang);
    ChiTietPhieuNhapHang delete(Integer id);
}
