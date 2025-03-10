package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.NhaCungCap;

public interface INhaCungCapService {
    List<NhaCungCap> findAll();
    Optional<NhaCungCap> findById(Integer id);
    NhaCungCap create(NhaCungCap nhaCungCap);
    NhaCungCap update(Integer id, NhaCungCap nhaCungCap);
    NhaCungCap delete(Integer id);
    Integer countNhaCungCap();
}
