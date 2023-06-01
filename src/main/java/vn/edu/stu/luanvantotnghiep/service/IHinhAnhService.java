package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.HinhAnh;

public interface IHinhAnhService {
    List<HinhAnh> findAll();
    Optional<HinhAnh> findById(Integer id);
    HinhAnh create(HinhAnh hinhAnh);
    HinhAnh update(HinhAnh hinhAnh);
    HinhAnh delete(Integer id);
}
