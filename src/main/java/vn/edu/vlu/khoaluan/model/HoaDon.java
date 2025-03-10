package vn.edu.vlu.khoaluan.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "trang_thai", length = 2)
    private Integer trangThai;
    @Column(name = "tong_tien")
    private Double tongTien;
    @Column(name = "so_tien_tra_gop")
    private Double soTienTraGop;
    @Column(name = "so_tien_tra_truoc")
    private Double soTienTraTruoc;
    @Column(name = "trang_thai_thanh_toan", length = 2)
    private Integer trangThaiThanhToan;
    @Column(name = "ten_khach_hang", length = 100)
    private String tenKhachHang;
    @Column(name = "dia_chi", length = 100)
    private String diaChi;
    
    @Column(name = "so_dien_thoai", length = 15)
    private String soDienThoai;
    @Column(name = "ghi_chu")
    private String ghiChu;
    @Column(name = "istragop", length = 1)
    private Boolean isTraGop;
    @Column(name = "so_thang_tra_gop", length = 2)
    private Integer soThangTraGop;
    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<TraGop> traGops;
    @Column(name = "create_date")
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ChiTietHoaDon> chiTietHoaDons;
    @JoinColumn(name = "khach_hang_id", referencedColumnName = "id")
    @ManyToOne
    private Customer user;
    @JoinColumn(name = "quan_ly_id", referencedColumnName = "id")
    @ManyToOne
    private Customer quanLy;
    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PhieuBaoHanh> phieuBaoHanhs;
    public HoaDon() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    public Double getTongTien() {
        return tongTien;
    }
    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
    public Integer getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }
    public void setTrangThaiThanhToan(Integer trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }
    public String getTenKhachHang() {
        return tenKhachHang;
    }
    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public String getGhiChu() {
        return ghiChu;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    public Boolean getIsTraGop() {
        return isTraGop;
    }
    public void setIsTraGop(Boolean isTraGop) {
        this.isTraGop = isTraGop;
    }
    public List<TraGop> getTraGops() {
        return traGops;
    }
    public void setTraGops(List<TraGop> traGops) {
        this.traGops = traGops;
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
    public List<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }
    public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }
    public Customer getUser() {
        return user;
    }
    public void setUser(Customer user) {
        this.user = user;
    }
    public Customer getQuanLy() {
        return quanLy;
    }
    public void setQuanLy(Customer quanLy) {
        this.quanLy = quanLy;
    }
    public Integer getSoThangTraGop() {
        return soThangTraGop;
    }
    public void setSoThangTraGop(Integer soThangTraGop) {
        this.soThangTraGop = soThangTraGop;
    }
    public Double getSoTienTraGop() {
        return soTienTraGop;
    }
    public void setSoTienTraGop(Double soTienTraGop) {
        this.soTienTraGop = soTienTraGop;
    }
    public Double getSoTienTraTruoc() {
        return soTienTraTruoc;
    }
    public void setSoTienTraTruoc(Double soTienTraTruoc) {
        this.soTienTraTruoc = soTienTraTruoc;
    }
    public List<PhieuBaoHanh> getPhieuBaoHanhs() {
        return phieuBaoHanhs;
    }
    public void setPhieuBaoHanhs(List<PhieuBaoHanh> phieuBaoHanhs) {
        this.phieuBaoHanhs = phieuBaoHanhs;
    }
    
    
}
