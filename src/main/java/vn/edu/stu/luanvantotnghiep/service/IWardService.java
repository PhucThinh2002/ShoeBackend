package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.Ward;

public interface IWardService {
    List<Ward> findAll();
    Optional<Ward> findById(Integer id);
    Ward create(Ward ward);
    Ward update(Ward ward);
    Ward delete(Integer id);
}
