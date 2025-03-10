package vn.edu.vlu.khoaluan.service.Impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.model.HoaDon;
import vn.edu.vlu.khoaluan.repository.HoaDonRepository;
import vn.edu.vlu.khoaluan.service.IHoaDonService;

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
        if(find.get().getTrangThai() <= 0 && find.get().getTrangThai() > 2){
            return null;
        }
        if(find.isPresent()){
            HoaDon save = find.get();
            save.setUpdateDate(Calendar.getInstance().getTime());
            save.setDiaChi(hoaDon.getDiaChi());
            save.setGhiChu(hoaDon.getGhiChu());
            save.setSoDienThoai(hoaDon.getSoDienThoai());
            save.setTongTien(hoaDon.getTongTien());
            save.setTenKhachHang(hoaDon.getTenKhachHang());
            save.setSoDienThoai(hoaDon.getSoDienThoai());
            save.setQuanLy(hoaDon.getQuanLy());
            save.setUser(hoaDon.getUser());
            save = hoaDonRepository.save(save);
            return save;
        }
        return null;
    }

    @Override
    public List<HoaDon> findAllHoaDonByKhachHang(Integer id) {
        return hoaDonRepository.findAllHoaDonByKhachHang(id);
    }

    @Override
    public HoaDon updateChuaThanhToan(Integer id) {
        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        hoaDon.setTrangThaiThanhToan(0);
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon updateChuanBiHang(Integer id) {
        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        hoaDon.setTrangThai(2);
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon updateDaThanhToan(Integer id) {
        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        hoaDon.setTrangThaiThanhToan(1);
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon updateGiaoHang(Integer id) {
        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        hoaDon.setTrangThai(3);
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon updateThanhCong(Integer id) {
        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        hoaDon.setTrangThai(4);
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon updateXoaDonHang(Integer id) {
        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        if(hoaDon.getTrangThai() >=2){
            return null;
        }
        hoaDon.setTrangThai(5);
        return hoaDonRepository.save(hoaDon);
    }
    public Integer countHoaDon(){
        return hoaDonRepository.countByTrangThai(1);
    }

    @Override
    public List<HoaDon> find10HoaDons() {
        // TODO Auto-generated method stub
        return hoaDonRepository.findFirst10ByTrangThaiOrderByCreateDateDesc(1);
    }
    
}
