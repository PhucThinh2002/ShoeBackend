package vn.edu.vlu.khoaluan.service.Impl;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.model.*;
import vn.edu.vlu.khoaluan.repository.*;
import vn.edu.vlu.khoaluan.service.*;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class PhieuBaoHanhServiceImpl implements IPhieuBaoHanhService{
    @Autowired
    private PhieuBaoHanhRepository phieuBaoHanhRepository;
    @Override
    public PhieuBaoHanh create(PhieuBaoHanh phieuBaoHanh) {
       return phieuBaoHanhRepository.save(phieuBaoHanh);
    }
    
}
