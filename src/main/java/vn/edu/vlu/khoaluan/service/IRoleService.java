package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.Role;

public interface IRoleService {
    List<Role> findAll();
    Optional<Role> findById(Integer id);
    Role create(Role role);
    Role update(Role role);
    Role delete(Integer id);
}
