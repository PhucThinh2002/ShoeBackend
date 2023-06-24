package vn.edu.stu.luanvantotnghiep.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.stu.luanvantotnghiep.model.ChiTietPhieuNhapHang;
import vn.edu.stu.luanvantotnghiep.repository.ChiTietPhieuNhapHangRepository;
import vn.edu.stu.luanvantotnghiep.service.IChiTietPhieuNhapHangService;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ChiTietPhieuNhapHang> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<ChiTietPhieuNhapHang> findById(Integer id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public ChiTietPhieuNhapHang update(ChiTietPhieuNhapHang chiTietPhieuNhapHang) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
