package vn.edu.vlu.khoaluan.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.model.ChiTietHoaDon;
import vn.edu.vlu.khoaluan.repository.ChiTietHoaDonRepository;
import vn.edu.vlu.khoaluan.service.IChiTietHoaDonService;

@Service
public class ChiTietHoaDonServiceImpl implements IChiTietHoaDonService{

    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;

    @Override
    public ChiTietHoaDon create(ChiTietHoaDon chiTietHoaDon) {
        // TODO Auto-generated method stub
        return chiTietHoaDonRepository.save(chiTietHoaDon);
    }

    @Override
    public ChiTietHoaDon delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ChiTietHoaDon> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<ChiTietHoaDon> findById(Integer id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public ChiTietHoaDon update(ChiTietHoaDon chiTietHoaDon) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
