package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.District;

public interface IDistrictService {
    List<District> findAll();
    Optional<District> findById(Long id);
    District create(District district);
    District update(District district);
    District delete(Long id);
    List<District> findByProvinceID(Long provinceid);
}
