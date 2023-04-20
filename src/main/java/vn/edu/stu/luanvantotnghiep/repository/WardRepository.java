package vn.edu.stu.luanvantotnghiep.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.stu.luanvantotnghiep.model.Ward;
public interface WardRepository extends JpaRepository<Ward, Long>{
    List<Ward> findByDistrict(int district);
}
