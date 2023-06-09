package vn.edu.stu.luanvantotnghiep.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.edu.stu.luanvantotnghiep.model.Ward;


public interface WardRepository extends JpaRepository<Ward, Long>{
    @Query(value = "SELECT * FROM ward WHERE district = :distrcitid", nativeQuery = true)
    List<Ward> findDistrictById(@Param("distrcitid") Long district);
}
