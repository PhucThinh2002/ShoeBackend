package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.District;

public interface IDistrictService {
    List<District> findAll();
    Optional<District> findById(Long id);
    District create(District district);
    District update(District district);
    District delete(Long id);
    List<District> findByProvinceID(Long provinceid);
}
