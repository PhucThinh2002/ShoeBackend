package vn.edu.vlu.khoaluan.service.Impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.model.PhieuNhapHang;
import vn.edu.vlu.khoaluan.repository.PhieuNhapHangRepository;
import vn.edu.vlu.khoaluan.service.IPhieuNhapHangService;

@Service
public class PhieuNhapHangServiceImpl implements IPhieuNhapHangService{
    @Autowired
    private PhieuNhapHangRepository phieuNhapHangRepository;

    @Override
    public List<PhieuNhapHang> findAll() {
        return phieuNhapHangRepository.findAll();
    }

    @Override
    public Optional<PhieuNhapHang> findById(Integer id) {
        return phieuNhapHangRepository.findById(id);
    }

    @Override
    public PhieuNhapHang create(PhieuNhapHang phieuNhapHang) {
        phieuNhapHang.setCreateDate(Calendar.getInstance().getTime());
        phieuNhapHang.setActive(1);
        return phieuNhapHangRepository.save(phieuNhapHang);
    }

    @Override
    public PhieuNhapHang update(PhieuNhapHang phieuNhapHang) {
        phieuNhapHang.setUpdateDate(Calendar.getInstance().getTime());
        return phieuNhapHangRepository.save(phieuNhapHang);
    }

    @Override
    public PhieuNhapHang delete(Integer id) {
        Optional<PhieuNhapHang> result = phieuNhapHangRepository.findById(id);
        if(result.isPresent()){
            PhieuNhapHang phieuNhapHang = result.get();
            phieuNhapHang.setActive(0);
            return phieuNhapHangRepository.save(phieuNhapHang);
        }
        return null;
    }
}
