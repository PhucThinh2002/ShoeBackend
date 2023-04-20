package vn.edu.stu.luanvantotnghiep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.stu.luanvantotnghiep.model.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByRoleKey(String roleKey);
}
