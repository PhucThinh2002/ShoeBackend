package vn.edu.vlu.khoaluan.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.model.HinhAnh;
import vn.edu.vlu.khoaluan.repository.HinhAnhRepository;
import vn.edu.vlu.khoaluan.service.IHinhAnhService;
@Service
public class HinhAnhServiecImpl implements IHinhAnhService{

    @Autowired
    private HinhAnhRepository hinhAnhRepository;
    @Override
    public HinhAnh create(HinhAnh hinhAnh) {
        // TODO Auto-generated method stub
        return hinhAnhRepository.save(hinhAnh);
    }

    @Override
    public HinhAnh delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<HinhAnh> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<HinhAnh> findById(Integer id) {
        return hinhAnhRepository.findById(id);
    }

    @Override
    public HinhAnh update(HinhAnh hinhAnh) {
        return hinhAnhRepository.save(hinhAnh);
    }
    
}
