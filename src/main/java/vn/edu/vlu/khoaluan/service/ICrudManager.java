package vn.edu.vlu.khoaluan.service;

import java.util.List;

import vn.edu.vlu.khoaluan.model.BaseEntity;

public interface ICrudManager {
    <T extends BaseEntity> List<T> findAll();
    <T extends BaseEntity> T findById(Integer id);
    <T extends BaseEntity> T createBaiViet(T baiViet);
    <T extends BaseEntity> T updateBaiViet(T baiViet);
    <T extends BaseEntity> T deleteBaiViet(Integer id);
}
