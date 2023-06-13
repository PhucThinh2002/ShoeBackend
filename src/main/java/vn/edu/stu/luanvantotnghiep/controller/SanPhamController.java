package vn.edu.stu.luanvantotnghiep.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.model.KhuyenMai;
import vn.edu.stu.luanvantotnghiep.model.LoaiSanPham;
import vn.edu.stu.luanvantotnghiep.model.ModelSanPham;
import vn.edu.stu.luanvantotnghiep.model.NhaSanXuat;
import vn.edu.stu.luanvantotnghiep.model.SanPham;
import vn.edu.stu.luanvantotnghiep.repository.KhuyenMaiRepository;
import vn.edu.stu.luanvantotnghiep.repository.LoaiSanPhamRepository;
import vn.edu.stu.luanvantotnghiep.repository.NhaSanXuatRepository;
import vn.edu.stu.luanvantotnghiep.repository.SanPhamRepository;
import vn.edu.stu.luanvantotnghiep.service.ISanPhamService;

@RestController
@CrossOrigin(maxAge = 3600)
public class SanPhamController {
    @Autowired
    private ISanPhamService sanPhamService;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;
    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;
    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;
    @GetMapping("/sanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findAllSanPham(){
        List<SanPham> lstSanPham = sanPhamService.findAll();
        if(lstSanPham.size() > 0){
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Không có dữ liệu sản phẩm!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @GetMapping("/sanpham/{id}")
    public FormatApi findSanPhamByID(@PathVariable("id") Integer id){
        Optional<SanPham> sanPham = sanPhamService.findById(id);
        if(sanPham.isPresent()){
            if(sanPham.get().getTrangThai() == 1){
                FormatApi result = new FormatApi();
                result.setData(sanPham);
                result.setMessage("Thành công!");
                result.setStatus(HttpStatus.OK);
                return result;
            }else{
                FormatApi result = new FormatApi();
                result.setData(null);
                result.setMessage("Không có dữ liệu sản phẩm có id = " + id);
                result.setStatus(HttpStatus.NO_CONTENT);
                return result;
            }   
        }else{
            FormatApi result = new FormatApi();
            result.setData(null);
            result.setMessage("Không có dữ liệu sản phẩm có id = " + id);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @GetMapping("/sanpham/danhmuc/{id}")
    public FormatApi findSanPhamByDanhMuc(@PathVariable("id") Integer id){
        List<SanPham> lstSanPham = sanPhamRepository.findSanPhamByDanhMucActive(id);
        if(!lstSanPham.isEmpty()){
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Không có dữ liệu sản phẩm có danh mục này");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @GetMapping("/sanpham/nhasanxuat/{id}")
    public FormatApi findSanPhamByNhaSanXuat(@PathVariable("id") Integer id){
        List<SanPham> lstSanPham = sanPhamRepository.findSanPhamByNhaSanXuatActive(id);
        if(!lstSanPham.isEmpty()){
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Không có dữ liệu sản phẩm có id = " + id);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @GetMapping("/sanphamactive")
    public FormatApi findSanPhamActive(){
        List<SanPham> lstSanPham = sanPhamRepository.findSanPhamActive();
        if(!lstSanPham.isEmpty()){
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }else{
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Không có dữ liệu sản phẩm");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @PostMapping("/sanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi createSanPham(@RequestBody ModelSanPham sanPham){
        SanPham data = new SanPham();
        data.setTenSanPham(sanPham.getTenSanPham());
        data.setGia(sanPham.getGia());
        data.setMoTa(sanPham.getMoTa());
        data.setSoLuongTon(sanPham.getSoLuongTon());
        data.setBaoHanh(sanPham.getBaoHanh());
        data.setThuocTinhs(sanPham.getThuocTinhs());
        data.setNamRaMat(sanPham.getNamRaMat());
        SanPham save = sanPhamService.create(data);
        save = setDanhMucToSanPham(save.getId(), sanPham.getDanhMuc().getId());
        save = setNhaSanXuatToSanPham(save.getId(), sanPham.getNhaSanXuat().getId());
        if(save != null){
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        }
        else{
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Tạo sản phẩm không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @PostMapping("/setdanhmuctosanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public SanPham setDanhMucToSanPham(@RequestParam("sanPham") Integer sanPham, @RequestParam("danhMuc") Integer danhMuc){
        Optional<SanPham> dataSanPham = sanPhamRepository.findById(sanPham);
        Optional<LoaiSanPham> dataLoaiSanPham = loaiSanPhamRepository.findById(danhMuc);
        dataSanPham.get().setDanhMuc(dataLoaiSanPham.get());
        return sanPhamRepository.save(dataSanPham.get());
    }
    @PostMapping("/setnhasanxuattosanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public SanPham setNhaSanXuatToSanPham(@RequestParam("sanPham") Integer sanPham, @RequestParam("nhaSanXuat") Integer nhaSanXuat){
        Optional<SanPham> dataSanPham = sanPhamRepository.findById(sanPham);
        Optional<NhaSanXuat> dataNhaSanXuat = nhaSanXuatRepository.findById(nhaSanXuat);
        dataSanPham.get().setNhaSanXuat(dataNhaSanXuat.get());
        return sanPhamRepository.save(dataSanPham.get());
    }
    @PostMapping("/setkhuyenmaitosanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public SanPham setKhuyenMaiToSanPham(@RequestParam("sanPham") Integer sanPham, @RequestParam("khuyenMai") Integer khuyenMai){
        Optional<SanPham> dataSanPham = sanPhamRepository.findById(sanPham);
        Optional<KhuyenMai> dataKhuyenMai = khuyenMaiRepository.findById(khuyenMai);
        List<SanPham> lstS = dataKhuyenMai.get().getSanPham();
        List<KhuyenMai> lstK = dataSanPham.get().getKhuyenMais();
        lstS.add(dataSanPham.get());
        lstK.add(dataKhuyenMai.get());
        dataSanPham.get().setKhuyenMais(lstK);
        dataKhuyenMai.get().setSanPham(lstS);
        khuyenMaiRepository.save(dataKhuyenMai.get());
        return sanPhamRepository.save(dataSanPham.get());
    }
}
