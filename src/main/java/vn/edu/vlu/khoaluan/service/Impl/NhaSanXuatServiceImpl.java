package vn.edu.vlu.khoaluan.service.Impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.model.NhaSanXuat;
import vn.edu.vlu.khoaluan.repository.NhaSanXuatRepository;
import vn.edu.vlu.khoaluan.service.INhaSanXuatService;

@Service
public class NhaSanXuatServiceImpl implements INhaSanXuatService{
    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @Override
    public List<NhaSanXuat> findAll() {
        return nhaSanXuatRepository.findAll();
    }

    @Override
    public Optional<NhaSanXuat> findById(Integer id) {
        return nhaSanXuatRepository.findById(id);
    }

    @Override
    public NhaSanXuat create(NhaSanXuat nhaSanXuat) {
        nhaSanXuat.setCreateDate(Calendar.getInstance().getTime());
        nhaSanXuat.setActive(1);
        return nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public NhaSanXuat update(Integer id, NhaSanXuat nhaSanXuat) {
        Optional<NhaSanXuat> data = nhaSanXuatRepository.findById(id);
        if(data.isPresent()){
            data.get().setMoTa(nhaSanXuat.getMoTa());
            data.get().setTenNhaSanXuat(nhaSanXuat.getTenNhaSanXuat());;
            data.get().setUpdateDate(Calendar.getInstance().getTime());
            return nhaSanXuatRepository.save(data.get());
        }else{
            return null;
        }
    }

    @Override
    public NhaSanXuat delete(Integer id) {
        Optional<NhaSanXuat> result = nhaSanXuatRepository.findById(id);
        if(result.isPresent()){
            NhaSanXuat nhaCungCap = result.get();
            nhaCungCap.setActive(0);
            return nhaSanXuatRepository.save(nhaCungCap);
        }
        return null;
    }

    @Override
    public Integer countNhaSanXuat() {
        
        return nhaSanXuatRepository.countByActive(1);
    }

    @Override
    public NhaSanXuat findByTenNhaSanXuat(String name) {
        return nhaSanXuatRepository.findByTenNhaSanXuat(name);
    }

}
