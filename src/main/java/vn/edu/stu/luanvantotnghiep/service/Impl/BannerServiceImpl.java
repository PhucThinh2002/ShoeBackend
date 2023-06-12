package vn.edu.stu.luanvantotnghiep.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.stu.luanvantotnghiep.model.Banner;
import vn.edu.stu.luanvantotnghiep.repository.BannerRepository;
import vn.edu.stu.luanvantotnghiep.service.IBannerService;

@Service
public class BannerServiceImpl implements IBannerService{
    @Autowired 
    private BannerRepository bannerRepository;
    @Override
    public List<Banner> findAll() {
        List<Banner> lstBanners = new ArrayList<>();
        bannerRepository.findAll().forEach(lstBanners::add);
        return lstBanners;
    }

    @Override
    public Optional<Banner> findById(Integer id) {
        Optional<Banner> banner = bannerRepository.findById(id);
        return banner;
    }

    @Override
    public Banner create(Banner banner) {
        return bannerRepository.save(banner);
    }

    @Override
    public Banner update(Integer id, Banner banner) {
        Optional<Banner> save = bannerRepository.findById(id);
        if(save.isPresent()){
            save.get().setTen(banner.getTen());
            return bannerRepository.save(banner);
        }else{
            return null;
        }
        
    }

    @Override
    public Banner delete(Integer id) {
        Optional<Banner> result = bannerRepository.findById(id);
        if(result.isPresent()){
            Banner banner = result.get();
            banner.setActive(0);
            return bannerRepository.save(banner);
        }
        return null;
    }

    @Override
    public List<Banner> findAllByActive() {
        // TODO Auto-generated method stub
        return bannerRepository.findAllBannerActive();
    }
    
}
