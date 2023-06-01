package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.BaiViet;

public interface IBaiVietService {
    List<BaiViet> findAll();
    Optional<BaiViet> findById(Integer id);
    BaiViet create(BaiViet baiViet);
    BaiViet update(BaiViet baiViet);
    BaiViet delete(Integer id);
}
