package vn.edu.vlu.khoaluan.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.model.ChiTietPhieuNhapHang;
import vn.edu.vlu.khoaluan.repository.ChiTietPhieuNhapHangRepository;
import vn.edu.vlu.khoaluan.service.IChiTietPhieuNhapHangService;
@Service
public class ChiTietPhieuNhapHangServiceImpl  implements IChiTietPhieuNhapHangService{
    @Autowired
    private ChiTietPhieuNhapHangRepository chiTietPhieuNhapHangRepository;

    @Override
    public ChiTietPhieuNhapHang create(ChiTietPhieuNhapHang chiTietPhieuNhapHang) {
        return chiTietPhieuNhapHangRepository.save(chiTietPhieuNhapHang);
    }

    @Override
    public ChiTietPhieuNhapHang delete(Integer id) {
        
        return null;
    }

    @Override
    public List<ChiTietPhieuNhapHang> findAll() {
        
        return null;
    }

    @Override
    public Optional<ChiTietPhieuNhapHang> findById(Integer id) {
        
        return Optional.empty();
    }

    @Override
    public ChiTietPhieuNhapHang update(ChiTietPhieuNhapHang chiTietPhieuNhapHang) {
        
        return null;
    }
    
}
