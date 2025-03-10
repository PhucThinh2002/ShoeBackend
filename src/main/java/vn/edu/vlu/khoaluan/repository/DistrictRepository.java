package vn.edu.vlu.khoaluan.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.edu.vlu.khoaluan.model.District;


public interface DistrictRepository extends JpaRepository<District, Long>{
    @Query(value = "SELECT * FROM district WHERE province = :province", nativeQuery = true)
    List<District> findByProvince(@Param("province") Long province);
}
