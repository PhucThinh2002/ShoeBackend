package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.Province;

public interface IProvinceService {
    List<Province> findAll();
    Optional<Province> findById(Long id);
    Province create(Province province);
    Province update(Province province);
    Province delete(Integer id);
}
