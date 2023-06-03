package vn.edu.stu.luanvantotnghiep.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.stu.luanvantotnghiep.model.District;
import vn.edu.stu.luanvantotnghiep.repository.DistrictRepository;
import vn.edu.stu.luanvantotnghiep.service.IDistrictService;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<District> findByProvinceID(Long provinceid) {
        return districtRepository.findByProvince(provinceid);
    }
    
}
