package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.HoaDon;

public interface IHoaDonService {
    List<HoaDon> findAll();
    Optional<HoaDon> findById(Integer id);
    HoaDon create(HoaDon hoaDon);
    HoaDon update(Integer id, HoaDon hoaDon);
    HoaDon delete(Integer id);
}
