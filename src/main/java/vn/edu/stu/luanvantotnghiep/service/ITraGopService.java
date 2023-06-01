package vn.edu.stu.luanvantotnghiep.service;

import java.util.List;
import java.util.Optional;

import vn.edu.stu.luanvantotnghiep.model.TraGop;

public interface ITraGopService {
    List<TraGop> findAll();
    Optional<TraGop> findById(Integer id);
    TraGop create(TraGop traGop);
    TraGop update(TraGop traGop);
    TraGop delete(Integer id);
}
