package vn.edu.vlu.khoaluan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.vlu.khoaluan.model.DashBoard;

import java.util.Date;


public interface DashBoardRepository extends JpaRepository<DashBoard, Integer>{
    DashBoard findByDateCreateBetween(Date dateCreate, Date dateFuture);
}
