package vn.edu.stu.luanvantotnghiep.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.stu.luanvantotnghiep.model.TraGop;
import vn.edu.stu.luanvantotnghiep.repository.TraGopRepository;
import vn.edu.stu.luanvantotnghiep.service.ITraGopService;

@Service
public class TraGopServiceImpl implements ITraGopService{
    @Autowired
    private TraGopRepository traGopRepository;

    @Override
    public TraGop create(TraGop traGop) {
        // TODO Auto-generated method stub
        return traGopRepository.save(traGop);
    }

    @Override
    public TraGop delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TraGop> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<TraGop> findById(Integer id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public TraGop update(TraGop traGop) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
