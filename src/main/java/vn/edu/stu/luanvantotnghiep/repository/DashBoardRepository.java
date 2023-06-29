package vn.edu.stu.luanvantotnghiep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.stu.luanvantotnghiep.model.DashBoard;
import java.util.Date;


public interface DashBoardRepository extends JpaRepository<DashBoard, Integer>{
    DashBoard findByDateCreateBefore(Date dateCreate);
}
