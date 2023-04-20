package vn.edu.stu.luanvantotnghiep.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.stu.luanvantotnghiep.model.District;


public interface DistrictRepository extends JpaRepository<District, Long>{
    List<District> findByProvince(int province);
}
