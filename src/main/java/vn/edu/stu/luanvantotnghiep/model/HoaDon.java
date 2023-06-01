package vn.edu.stu.luanvantotnghiep.model;

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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TraGop> traGops;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietHoaDon> chiTietHoaDons;
    @JoinColumn(name = "khach_hang_id", referencedColumnName = "id")
    @ManyToOne
    private Customer user;
    @JoinColumn(name = "quan_ly_id", referencedColumnName = "id")
    @ManyToOne
    private Customer quanLy;
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
    
}
