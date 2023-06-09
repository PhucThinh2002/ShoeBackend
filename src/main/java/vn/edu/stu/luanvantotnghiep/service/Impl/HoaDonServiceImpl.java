package vn.edu.stu.luanvantotnghiep.service.Impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.stu.luanvantotnghiep.model.HoaDon;
import vn.edu.stu.luanvantotnghiep.repository.HoaDonRepository;
import vn.edu.stu.luanvantotnghiep.service.IHoaDonService;

@Service
public class HoaDonServiceImpl implements IHoaDonService{
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public HoaDon create(HoaDon hoaDon) {
        // TODO Auto-generated method stub
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<HoaDon> findAll() {
        // TODO Auto-generated method stub
        return hoaDonRepository.findAll();
    }

    @Override
    public Optional<HoaDon> findById(Integer id) {
        // TODO Auto-generated method stub
        return hoaDonRepository.findById(id);
    }

    @Override
    public HoaDon update(Integer id, HoaDon hoaDon) {
        Optional<HoaDon> find = hoaDonRepository.findById(id);
        if(find.isPresent()){
            HoaDon save = find.get();
            save.setUpdateDate(Calendar.getInstance().getTime());
            save.setDiaChi(hoaDon.getDiaChi());
            save.setGhiChu(hoaDon.getGhiChu());
            save.setSoDienThoai(hoaDon.getSoDienThoai());
            save.setTongTien(hoaDon.getTongTien());
            save.setTenKhachHang(hoaDon.getTenKhachHang());
            save.setSoDienThoai(hoaDon.getSoDienThoai());
            save = hoaDonRepository.save(save);
            return save;
        }
        return null;
    }
}
