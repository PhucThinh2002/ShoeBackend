package vn.edu.stu.luanvantotnghiep.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.stu.luanvantotnghiep.model.BaiViet;
import vn.edu.stu.luanvantotnghiep.repository.BaiVietRepository;
import vn.edu.stu.luanvantotnghiep.service.IBaiVietService;

@Service
public class BaiVietServiceImpl implements IBaiVietService{
    @Autowired
    private BaiVietRepository baiVietRepository;

    @Override
    public List<BaiViet> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<BaiViet> findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public BaiViet create(BaiViet baiViet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public BaiViet update(BaiViet baiViet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public BaiViet delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
