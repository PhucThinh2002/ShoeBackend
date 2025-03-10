package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.Ward;

public interface IWardService {
    List<Ward> findAll();
    Optional<Ward> findById(Long id);
    Ward create(Ward ward);
    Ward update(Ward ward);
    Ward delete(Long id);
    List<Ward> findByDistrictID(Long district);
}
