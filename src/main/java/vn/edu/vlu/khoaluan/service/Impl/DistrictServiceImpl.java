package vn.edu.vlu.khoaluan.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.model.District;
import vn.edu.vlu.khoaluan.repository.DistrictRepository;
import vn.edu.vlu.khoaluan.service.IDistrictService;

@Service
public class DistrictServiceImpl implements IDistrictService{
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public Optional<District> findById(Long id) {
        return districtRepository.findById(id);
    }

    @Override
    public District create(District district) {
       return districtRepository.save(district);
    }

    @Override
    public District update(District district) {
        return districtRepository.save(district);
    }

    @Override
    public District delete(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<District> findByProvinceID(Long provinceid) {
        return districtRepository.findByProvince(provinceid);
    }
    
}
