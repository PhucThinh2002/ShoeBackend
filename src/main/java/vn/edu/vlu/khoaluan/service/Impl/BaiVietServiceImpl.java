package vn.edu.vlu.khoaluan.service.Impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.model.BaiViet;
import vn.edu.vlu.khoaluan.repository.BaiVietRepository;
import vn.edu.vlu.khoaluan.service.IBaiVietService;

@Service
public class BaiVietServiceImpl implements IBaiVietService{
    @Autowired
    private BaiVietRepository baiVietRepository;

    @Override
    public List<BaiViet> findAll() {
        return baiVietRepository.findAll();
    }

    @Override
    public Optional<BaiViet> findById(Integer id) {
        return baiVietRepository.findById(id);
    }

    @Override
    public BaiViet create(BaiViet baiViet) {
        return baiVietRepository.save(baiViet);
    }

    @Override
    public BaiViet update(Integer id, BaiViet baiViet) {
        Optional<BaiViet> data = baiVietRepository.findById(id);
        if(data.isPresent()){
            data.get().setNoiDung(baiViet.getNoiDung());
            data.get().setTieuDe(baiViet.getTieuDe());
            data.get().setUpdateDate(Calendar.getInstance().getTime());
            return baiVietRepository.save(data.get());
        }else{
            return null;
        }
        
    }

    @Override
    public BaiViet delete(Integer id) {
        Optional<BaiViet> result = baiVietRepository.findById(id);
        if(result.isPresent()){
            BaiViet baiViet = result.get();
            baiViet.setActive(0);
            return baiVietRepository.save(baiViet);
        }
        return null;
    }

    @Override
    public List<BaiViet> findAllActive() {
        return baiVietRepository.findByActive(1);
    }

}
