package vn.edu.stu.luanvantotnghiep.service.Impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.stu.luanvantotnghiep.model.*;
import vn.edu.stu.luanvantotnghiep.repository.*;
import vn.edu.stu.luanvantotnghiep.service.*;
@Service
public class PhieuBaoHanhServiceImpl implements IPhieuBaoHanhService{
    @Autowired
    private PhieuBaoHanhRepository phieuBaoHanhRepository;
    @Override
    public PhieuBaoHanh create(PhieuBaoHanh phieuBaoHanh) {
       return phieuBaoHanhRepository.save(phieuBaoHanh);
    }
    
}
