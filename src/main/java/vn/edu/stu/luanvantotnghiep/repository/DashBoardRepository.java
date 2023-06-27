package vn.edu.stu.luanvantotnghiep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.edu.stu.luanvantotnghiep.model.DashBoard;
import java.util.Date;


public interface DashBoardRepository extends JpaRepository<DashBoard, Integer>{
    DashBoard findByDateCreateBefore(Date dateCreate);
}
