package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.ChiTietHoaDon;

public interface IChiTietHoaDonService {
    List<ChiTietHoaDon> findAll();
    Optional<ChiTietHoaDon> findById(Integer id);
    ChiTietHoaDon create(ChiTietHoaDon chiTietHoaDon);
    ChiTietHoaDon update(ChiTietHoaDon chiTietHoaDon);
    ChiTietHoaDon delete(Integer id);
}
