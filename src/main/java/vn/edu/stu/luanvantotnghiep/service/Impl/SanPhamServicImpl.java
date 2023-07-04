package vn.edu.stu.luanvantotnghiep.service.Impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vn.edu.stu.luanvantotnghiep.model.LoaiSanPham;
import vn.edu.stu.luanvantotnghiep.model.SanPham;
import vn.edu.stu.luanvantotnghiep.model.ThuocTinh;
import vn.edu.stu.luanvantotnghiep.repository.SanPhamRepository;
import vn.edu.stu.luanvantotnghiep.repository.ThuocTinhRepository;
import vn.edu.stu.luanvantotnghiep.service.ISanPhamService;

@Service
public class SanPhamServicImpl implements ISanPhamService{
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private ThuocTinhRepository thuocTinhRepository;


    @Override
    public Optional<SanPham> findById(Integer id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public SanPham create(SanPham sanPham) {
        sanPham.setTrangThai(1);
        sanPham.setCreateDate(Calendar.getInstance().getTime());
        SanPham save =  sanPhamRepository.save(sanPham);
        for(ThuocTinh t : save.getThuocTinhs()){
            t.setSanPham(save);
            thuocTinhRepository.save(t);
        }
        return sanPham;
    }

    @Override
    public SanPham update(SanPham sanPham) {
        sanPham.setUpdateDate(Calendar.getInstance().getTime());
        return sanPhamRepository.saveAndFlush(sanPham);
    }

    @Override
    public SanPham delete(Integer id) {
        Optional<SanPham> sanPham = findById(id);
        if(sanPham.isPresent()){
            sanPham.get().setTrangThai(0);
            return sanPhamRepository.save(sanPham.get());
        }
        return null;
    }

    @Override
    public Page<SanPham> findAll(Integer limit, Integer currentpage) {
        PageRequest pageable = PageRequest.of(limit, currentpage);
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public Page<SanPham> findSanPhamActive(Integer limit, Integer currentpage) {
         PageRequest pageable = PageRequest.of(currentpage, limit);
        return sanPhamRepository.findSanPhamActive(pageable);
    }

    @Override
    public Integer countSanPham() {
        // TODO Auto-generated method stub
        return sanPhamRepository.countByTrangThai(1);
    }
    @Override
    public List<SanPham> findSanPhamByNhaSanXuatActive(Integer id){
        return sanPhamRepository.findSanPhamByNhaSanXuatActive(id);
    }
    @Override
    public List<SanPham> findByLoaiSanPhamAndTrangThai(LoaiSanPham loaiSanPham, Integer id){
        return sanPhamRepository.findByDanhMucAndTrangThai(loaiSanPham, id);
    }
}
