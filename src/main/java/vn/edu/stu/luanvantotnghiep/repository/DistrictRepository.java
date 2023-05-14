package vn.edu.stu.luanvantotnghiep.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.edu.stu.luanvantotnghiep.model.District;


public interface DistrictRepository extends JpaRepository<District, Long>{
    @Query(value = "SELECT d FROM district as d WHERE d.province = :province", nativeQuery = true)
    List<District> findByProvince(@Param("province") int province);
}
