package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.KhuyenMai;

public interface IKhuyenMaiService {
    List<KhuyenMai> findAll();
    Optional<KhuyenMai> findById(Integer id);
    KhuyenMai create(KhuyenMai khuyenMai);
    KhuyenMai update(Integer id, KhuyenMai khuyenMai);
    KhuyenMai delete(Integer id);
    Integer countKhuyenMai();
}
