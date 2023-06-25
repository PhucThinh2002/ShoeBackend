package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.NhaSanXuat;

public interface INhaSanXuatService {
    List<NhaSanXuat> findAll();
    Optional<NhaSanXuat> findById(Integer id);
    NhaSanXuat create(NhaSanXuat nhaSanXuat);
    NhaSanXuat update(Integer id, NhaSanXuat nhaSanXuat);
    NhaSanXuat delete(Integer id);
    Integer countNhaSanXuat();
}
