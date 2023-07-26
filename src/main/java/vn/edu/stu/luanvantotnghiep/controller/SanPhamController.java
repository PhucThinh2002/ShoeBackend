package vn.edu.stu.luanvantotnghiep.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.stu.luanvantotnghiep.model.FormatApi;
import vn.edu.stu.luanvantotnghiep.model.FormatApiSanPham;
import vn.edu.stu.luanvantotnghiep.model.HinhAnh;
import vn.edu.stu.luanvantotnghiep.model.KhuyenMai;
import vn.edu.stu.luanvantotnghiep.model.LoaiSanPham;
import vn.edu.stu.luanvantotnghiep.model.ModelSanPham;
import vn.edu.stu.luanvantotnghiep.model.ModelSanPhamTonKho;
import vn.edu.stu.luanvantotnghiep.model.NhaSanXuat;
import vn.edu.stu.luanvantotnghiep.model.SanPham;
import vn.edu.stu.luanvantotnghiep.service.IHinhAnhService;
import vn.edu.stu.luanvantotnghiep.service.IKhuyenMaiService;
import vn.edu.stu.luanvantotnghiep.service.ILoaiSanPhamService;
import vn.edu.stu.luanvantotnghiep.service.INhaSanXuatService;
import vn.edu.stu.luanvantotnghiep.service.ISanPhamService;

@RestController
@CrossOrigin(maxAge = 3600)
public class SanPhamController {
    @Autowired
    private ISanPhamService sanPhamService;
    @Autowired
    private ILoaiSanPhamService loaiSanPhamService;
    @Autowired
    private INhaSanXuatService nhaSanXuatService;
    @Autowired
    private IHinhAnhService hinhAnhService;
    @Autowired
    private IKhuyenMaiService khuyenMaiService;
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @GetMapping("/sanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi findAllSanPham(@RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(defaultValue = "10") Integer currentpage) {
        Page<SanPham> lstSanPham = sanPhamService.findAll(limit, currentpage);
        if (lstSanPham.getSize() > 0) {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Không có dữ liệu sản phẩm!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }

    @GetMapping("/sanpham/{id}")
    public FormatApi findSanPhamByID(@PathVariable("id") Integer id) {
        Optional<SanPham> sanPham = sanPhamService.findById(id);
        if (sanPham.isPresent()) {
            if (sanPham.get().getTrangThai() == 1) {
                FormatApi result = new FormatApi();
                result.setData(sanPham);
                result.setMessage("Thành công!");
                result.setStatus(HttpStatus.OK);
                return result;
            } else {
                FormatApi result = new FormatApi();
                result.setData(null);
                result.setMessage("Không có dữ liệu sản phẩm có id = " + id);
                result.setStatus(HttpStatus.NO_CONTENT);
                return result;
            }
        } else {
            FormatApi result = new FormatApi();
            result.setData(null);
            result.setMessage("Không có dữ liệu sản phẩm có id = " + id);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }

    @GetMapping("/sanpham/nhasanxuat/{tenHangSanXuat}")
    public FormatApi findSanPhamByNhaSanXuat(@PathVariable("tenHangSanXuat") String tenHangSanXuat) {
        NhaSanXuat nhaSanXuat = nhaSanXuatService.findByTenNhaSanXuat(tenHangSanXuat);
        if (nhaSanXuat == null) {
            FormatApi result = new FormatApi();
            result.setData(nhaSanXuat);
            result.setMessage("Không có dữ liệu sản phẩm của nhà sản xuất có tên = " + tenHangSanXuat);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        } else {
            List<SanPham> lstSanPham = sanPhamService.findSanPhamByNhaSanXuatActive(nhaSanXuat.getId());
            if (!lstSanPham.isEmpty()) {
                FormatApi result = new FormatApi();
                result.setData(lstSanPham);
                result.setMessage("Thành công!");
                result.setStatus(HttpStatus.OK);
                return result;
            } else {
                FormatApi result = new FormatApi();
                result.setData(lstSanPham);
                result.setMessage("Không có dữ liệu sản phẩm của nhà sản xuất có tên = " + tenHangSanXuat);
                result.setStatus(HttpStatus.NO_CONTENT);
                return result;
            }
        }

    }

    @GetMapping("/sanpham/loaisanpham/{tenLoaiSanPham}")
    public FormatApi findSanPhamByLoaiSanPham(@PathVariable("tenLoaiSanPham") String tenLoaiSanPham) {
        LoaiSanPham loaiSanPham = loaiSanPhamService.findByName(tenLoaiSanPham);
        List<SanPham> lstSanPham = sanPhamService.findByLoaiSanPhamAndTrangThai(loaiSanPham, 1);
        if (!lstSanPham.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Không có dữ liệu sản phẩm của loại sản phẩm có tên = " + tenLoaiSanPham);
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }

    @GetMapping("/sanphamactive")
    public FormatApiSanPham findSanPhamActive(@RequestParam(defaultValue = "10") Integer currentpage,
            @RequestParam(defaultValue = "10") Integer limit) {
        Page<SanPham> lstSanPham = sanPhamService.findSanPhamActive(limit, currentpage);
        if (lstSanPham.getSize() > 0) {
            FormatApiSanPham result = new FormatApiSanPham();
            result.setData(lstSanPham.getContent());
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            result.setCurrentpage(currentpage);
            result.setTotalPage(lstSanPham.getTotalPages());
            return result;
        } else {
            FormatApiSanPham result = new FormatApiSanPham();
            result.setData(lstSanPham.getContent());
            result.setMessage("Không có dữ liệu sản phẩm");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }

    @PostMapping("/sanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public FormatApi createSanPham(@RequestBody ModelSanPham sanPham) {
        SanPham data = new SanPham();
        HinhAnh hinhAnh = hinhAnhService.findById(sanPham.getHinhAnh()).get();
        List<HinhAnh> hinhAnhs = new ArrayList<>();
        hinhAnhs.add(hinhAnh);
        data.setTenSanPham(sanPham.getTenSanPham());
        data.setGia(sanPham.getGia());
        data.setMoTa(sanPham.getMoTa());
        data.setSoLuongTon(sanPham.getSoLuongTon());
        data.setBaoHanh(sanPham.getBaoHanh());
        data.setThuocTinhs(sanPham.getThuocTinhs());
        data.setNamRaMat(sanPham.getNamRaMat());
        data.setHinhAnhs(hinhAnhs);
        SanPham save = sanPhamService.create(data);
        save = setDanhMucToSanPham(save.getId(), sanPham.getDanhMuc().getId());
        save = setNhaSanXuatToSanPham(save.getId(), sanPham.getNhaSanXuat().getId());
        if (save != null) {
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Tạo sản phẩm không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }

    @PostMapping("/setdanhmuctosanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public SanPham setDanhMucToSanPham(@RequestParam("sanPham") Integer sanPham,
            @RequestParam("danhMuc") Integer danhMuc) {
        Optional<SanPham> dataSanPham = sanPhamService.findById(sanPham);
        Optional<LoaiSanPham> dataLoaiSanPham = loaiSanPhamService.findById(danhMuc);
        dataSanPham.get().setDanhMuc(dataLoaiSanPham.get());
        return sanPhamService.update(dataSanPham.get());
    }

    @PostMapping("/setnhasanxuattosanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public SanPham setNhaSanXuatToSanPham(@RequestParam("sanPham") Integer sanPham,
            @RequestParam("nhaSanXuat") Integer nhaSanXuat) {
        Optional<SanPham> dataSanPham = sanPhamService.findById(sanPham);
        Optional<NhaSanXuat> dataNhaSanXuat = nhaSanXuatService.findById(nhaSanXuat);
        dataSanPham.get().setNhaSanXuat(dataNhaSanXuat.get());
        return sanPhamService.update(dataSanPham.get());
    }

    @PostMapping("/setkhuyenmaitosanpham")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public SanPham setKhuyenMaiToSanPham(@RequestParam("sanPham") Integer sanPham,
            @RequestParam("khuyenMai") Integer khuyenMai) {
        Optional<SanPham> dataSanPham = sanPhamService.findById(sanPham);
        Optional<KhuyenMai> dataKhuyenMai = khuyenMaiService.findById(khuyenMai);
        List<SanPham> lstS = dataKhuyenMai.get().getSanPham();
        List<KhuyenMai> lstK = dataSanPham.get().getKhuyenMais();
        lstS.add(dataSanPham.get());
        lstK.add(dataKhuyenMai.get());
        dataSanPham.get().setKhuyenMais(lstK);
        dataKhuyenMai.get().setSanPham(lstS);
        khuyenMaiService.update(dataKhuyenMai.get().getId(), dataKhuyenMai.get());
        return sanPhamService.update(dataSanPham.get());
    }
    @PutMapping("/sanpham/{id}")
    public FormatApi updateSanPham(@PathVariable("id") Integer id, @RequestBody SanPham sanPham){
        SanPham find = sanPhamService.findById(id).get();
        find.setBaoHanh(sanPham.getBaoHanh());
        find.setDanhMuc(sanPham.getDanhMuc());
        find.setGia(sanPham.getGia());
        find.setMoTa(sanPham.getMoTa());
        find.setNamRaMat(sanPham.getNamRaMat());
        find.setTenSanPham(sanPham.getTenSanPham());
        SanPham save = sanPhamService.update(find);
        if (save != null) {
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(save);
            result.setMessage("Sửa sản phẩm không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @DeleteMapping("/sanpham/delete/{id}")
    public FormatApi deleteSanPham(@PathVariable("id") Integer id){
        SanPham sanPham = sanPhamService.findById(id).get();
        if (sanPham != null) {
            sanPham.setTrangThai(0);
            sanPham = sanPhamService.update(sanPham);
            FormatApi result = new FormatApi();
            result.setData(sanPham);
            result.setMessage("Xóa sản phẩm có id = " + id +" thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(sanPham);
            result.setMessage("Xóa sản phẩm có id = " + id +" không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @PutMapping("/sanpham/active/{id}")
    public FormatApi activeSanPham(@PathVariable("id") Integer id){
        SanPham sanPham = sanPhamService.findById(id).get();
        sanPham.setTrangThai(1);
        sanPham = sanPhamService.update(sanPham);
        if (sanPham != null) {
            FormatApi result = new FormatApi();
            result.setData(sanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(sanPham);
            result.setMessage("Không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @GetMapping("/sanphamsearch")
    public FormatApi search(@RequestParam("keyword") String keyword) throws PersistenceException, QueryException{
        Query query = entityManager.createNamedQuery("SanPham.findSanPham").setParameter("keyword","%" + keyword + "%");
        List<SanPham> lstSanPham = query.getResultList();
        System.out.println("số lượng sản phẩm search = " + lstSanPham.size());
        if (!lstSanPham.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
        
    }
    @GetMapping("/sanphamfilter")
    public FormatApi filter(@RequestParam("nhasanxuat") String nhaSanXuat,
                            @RequestParam("loaisanpham") String loaisanpham,
                            @RequestParam("tugia") Double tugia,
                            @RequestParam("dengia") Double dengia ){
        Query query = entityManager.createNamedQuery("SanPham.findSanPhamFilter");
        if(nhaSanXuat.isEmpty()){
            query.setParameter("nhasanxuat", null);
        }else{
            query.setParameter("nhasanxuat", Integer.parseInt(nhaSanXuat));
        }
        if(loaisanpham.isEmpty()){
            query.setParameter("danhmuc", null);
        }else{
            query.setParameter("danhmuc", Integer.parseInt(loaisanpham));
        }
        query.setParameter("tugia", tugia);
        query.setParameter("dengia", dengia);
        List<SanPham> lstSanPham = query.getResultList();
        System.out.println("số lượng sản phẩm search = " + lstSanPham.size());
        if (!lstSanPham.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
        
    }
    @GetMapping("/get10sanpham")
    public FormatApi find10SanPhamGiaCaoNhat(){
        List<SanPham> lstSanPham = sanPhamService.findSanPham10GiaCaoNhat();
        if (!lstSanPham.isEmpty()) {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.OK);
            return result;
        } else {
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Không thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
        }
    }
    @GetMapping("/sanphamtonkho")
    public FormatApi SanPhamTonKho(){
        List<SanPham> lstSanPham = sanPhamService.findByTrangThai(1);
        List<ModelSanPhamTonKho> lstSanPhamTonKho = new ArrayList<>();
        for(SanPham d : lstSanPham){
            ModelSanPhamTonKho sptk = new ModelSanPhamTonKho();
            sptk.setSanPham(d.getTenSanPham());
            sptk.setSanLuongTonKho(d.getSoLuongTon());
            lstSanPhamTonKho.add(sptk);
        }
            FormatApi result = new FormatApi();
            result.setData(lstSanPhamTonKho);
            result.setMessage("Thành công!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
    }

    @GetMapping("/sanphamhettonkho")
    public FormatApi SanPhamHetTonKho(){
        List<SanPham> lstSanPham = sanPhamService.findBySoLuongTon(0, 1);
        // List<ModelSanPhamTonKho> lstSanPhamTonKho = new ArrayList<>();
        // for(SanPham d : lstSanPham){
        //     ModelSanPhamTonKho sptk = new ModelSanPhamTonKho();
        //     sptk.setSanPham(d.getTenSanPham());
        //     sptk.setSanLuongTonKho(d.getSoLuongTon());
        //     lstSanPhamTonKho.add(sptk);
        // }
            FormatApi result = new FormatApi();
            result.setData(lstSanPham);
            result.setMessage("Có " + lstSanPham.size() + " sản phẩm đã hết hàng trong kho!");
            result.setStatus(HttpStatus.NO_CONTENT);
            return result;
    }
}
