package vn.edu.vlu.khoaluan.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.model.Province;
import vn.edu.vlu.khoaluan.repository.ProvinceRepository;
import vn.edu.vlu.khoaluan.service.IProvinceService;
@Service
public class ProvinceServiceImpl implements IProvinceService{
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public Province create(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public Province delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        // TODO Auto-generated method stub
        return provinceRepository.findById(id);
    }


    @Override
    public Province update(Province province) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
