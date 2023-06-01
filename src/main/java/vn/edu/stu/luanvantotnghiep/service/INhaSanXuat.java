package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.NhaSanXuat;

public interface INhaSanXuat {
    List<NhaSanXuat> findAll();
    Optional<NhaSanXuat> findById(Integer id);
    NhaSanXuat create(NhaSanXuat nhaSanXuat);
    NhaSanXuat update(NhaSanXuat nhaSanXuat);
    NhaSanXuat delete(Integer id);
}
