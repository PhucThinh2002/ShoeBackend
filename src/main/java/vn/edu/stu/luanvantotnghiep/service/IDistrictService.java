package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.District;

public interface IDistrictService {
    List<District> findAll();
    Optional<District> findById(Integer id);
    District create(District district);
    District update(District district);
    District delete(Integer id);
}
