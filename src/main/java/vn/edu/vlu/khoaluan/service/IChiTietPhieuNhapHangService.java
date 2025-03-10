package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.ChiTietPhieuNhapHang;

public interface IChiTietPhieuNhapHangService {
    List<ChiTietPhieuNhapHang> findAll();
    Optional<ChiTietPhieuNhapHang> findById(Integer id);
    ChiTietPhieuNhapHang create(ChiTietPhieuNhapHang chiTietPhieuNhapHang);
    ChiTietPhieuNhapHang update(ChiTietPhieuNhapHang chiTietPhieuNhapHang);
    ChiTietPhieuNhapHang delete(Integer id);
}
