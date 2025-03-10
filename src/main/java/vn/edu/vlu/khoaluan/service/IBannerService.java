package vn.edu.vlu.khoaluan.service;

import java.util.List;
import java.util.Optional;

import vn.edu.vlu.khoaluan.model.Banner;

public interface IBannerService {
    List<Banner> findAll();
    List<Banner> findAllByActive();
    Optional<Banner> findById(Integer id);
    Banner create(Banner banner);
    Banner update(Integer id, Banner banner);
    Banner delete(Integer id);
}
