package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.PhieuNhapHang;

public interface IPhieuNhapHangService {
    List<PhieuNhapHang> findAll();
    Optional<PhieuNhapHang> findById(Integer id);
    PhieuNhapHang create(PhieuNhapHang phieuNhapHang);
    PhieuNhapHang update(PhieuNhapHang phieuNhapHang);
    PhieuNhapHang delete(Integer id);
}
