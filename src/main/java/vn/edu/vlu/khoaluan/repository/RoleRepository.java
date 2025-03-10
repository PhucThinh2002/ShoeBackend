package vn.edu.vlu.khoaluan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.vlu.khoaluan.model.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByRoleKey(String roleKey);
}
