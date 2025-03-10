package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.TraGop;

public interface ITraGopService {
    List<TraGop> findAll();
    Optional<TraGop> findById(Integer id);
    TraGop create(TraGop traGop);
    TraGop update(TraGop traGop);
    TraGop delete(Integer id);
}
