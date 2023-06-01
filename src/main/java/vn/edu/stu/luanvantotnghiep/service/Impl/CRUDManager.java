package vn.edu.stu.luanvantotnghiep.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.edu.stu.luanvantotnghiep.model.BaseEntity;
import vn.edu.stu.luanvantotnghiep.service.ICrudManager;

@Service
public class CRUDManager implements ICrudManager{

    @Override
    public <T extends BaseEntity> List<T> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <T extends BaseEntity> T findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public <T extends BaseEntity> T createBaiViet(T baiViet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBaiViet'");
    }

    @Override
    public <T extends BaseEntity> T updateBaiViet(T baiViet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBaiViet'");
    }

    @Override
    public <T extends BaseEntity> T deleteBaiViet(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBaiViet'");
    }
    
}
