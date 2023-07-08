package vn.edu.stu.luanvantotnghiep.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "san_pham")
@NamedQueries(
    {
        @NamedQuery(name="SanPham.findSanPham", query="SELECT s FROM SanPham s where (s.nhaSanXuat.tenNhaSanXuat LIKE :keyword) OR (s.danhMuc.tenDanhMuc LIKE :keyword) OR (s.tenSanPham LIKE :keyword) AND s.trangThai = 1"),
        @NamedQuery(name="SanPham.findSanPhamFilter", query="SELECT s FROM SanPham s where (:nhasanxuat IS NULL OR s.nhaSanXuat.id = :nhasanxuat) AND (:danhmuc IS NULL OR s.danhMuc.id = :danhmuc) AND s.gia >= :tugia AND s.gia <= :dengia AND s.trangThai = 1"),
}
)
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_san_pham", length = 100)
    private String tenSanPham;
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HinhAnh> hinhAnhs;
    @Column(name = "gia")
    private double gia;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "trang_thai", length = 1)
    private Integer trangThai;
     @Column(name = "nam_ra_mat", length = 10)
    private String namRaMat;
    @Column(name = "so_luong_ton", length = 5)
    private Integer soLuongTon;
    @Column(name = "bao_hanh", length = 100)
    private String baoHanh;
    @Column(name = "create_date")
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @JoinColumn(name = "danh_muc", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private LoaiSanPham danhMuc;
    @JoinColumn(name = "nha_san_xuat", referencedColumnName = "id")
    @ManyToOne
    private NhaSanXuat nhaSanXuat;
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ChiTietPhieuNhapHang> chiTietPhieuNhapHang;
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ChiTietHoaDon> chiTietDonDatHangs;
    @ManyToMany(mappedBy = "sanPham")
    @JsonIgnore
    private List<KhuyenMai> khuyenMais;
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ThuocTinh> thuocTinhs;
    public SanPham() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTenSanPham() {
        return tenSanPham;
    }
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    public List<HinhAnh> getHinhAnhs() {
        return hinhAnhs;
    }
    public void setHinhAnhs(List<HinhAnh> hinhAnhs) {
        this.hinhAnhs = hinhAnhs;
    }
    public double getGia() {
        return gia;
    }
    public void setGia(double gia) {
        this.gia = gia;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public Integer getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    public String getNamRaMat() {
        return namRaMat;
    }
    public void setNamRaMat(String namRaMat) {
        this.namRaMat = namRaMat;
    }
    public Integer getSoLuongTon() {
        return soLuongTon;
    }
    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }
    public String getBaoHanh() {
        return baoHanh;
    }
    public void setBaoHanh(String baoHanh) {
        this.baoHanh = baoHanh;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public LoaiSanPham getDanhMuc() {
        return danhMuc;
    }
    public void setDanhMuc(LoaiSanPham danhMuc) {
        this.danhMuc = danhMuc;
    }
    public NhaSanXuat getNhaSanXuat() {
        return nhaSanXuat;
    }
    public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
    
    public List<ChiTietPhieuNhapHang> getChiTietPhieuNhapHang() {
        return chiTietPhieuNhapHang;
    }
    public void setChiTietPhieuNhapHang(List<ChiTietPhieuNhapHang> chiTietPhieuNhapHang) {
        this.chiTietPhieuNhapHang = chiTietPhieuNhapHang;
    }
    public List<ChiTietHoaDon> getChiTietDonDatHangs() {
        return chiTietDonDatHangs;
    }
    public void setChiTietDonDatHangs(List<ChiTietHoaDon> chiTietDonDatHangs) {
        this.chiTietDonDatHangs = chiTietDonDatHangs;
    }
    public List<KhuyenMai> getKhuyenMais() {
        return khuyenMais;
    }
    public void setKhuyenMais(List<KhuyenMai> khuyenMais) {
        this.khuyenMais = khuyenMais;
    }
    public List<ThuocTinh> getThuocTinhs() {
        return thuocTinhs;
    }
    public void setThuocTinhs(List<ThuocTinh> thuocTinhs) {
        this.thuocTinhs = thuocTinhs;
    }

}
