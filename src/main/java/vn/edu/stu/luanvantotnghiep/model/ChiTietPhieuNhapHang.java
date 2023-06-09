package vn.edu.stu.luanvantotnghiep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "chi_tiet_phieu_nhap_hang")
public class ChiTietPhieuNhapHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "seri", length = 50)
    private String seri;
    @Column(name = "gia_nhap")
    private Double giaNhap;
    @Column(name = "so_luong")
    private Integer soLuong;
    @JoinColumn(name = "phieu_nhap_hang_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private PhieuNhapHang phieuNhapHang;
    @JoinColumn(name = "san_pham_id", referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    private SanPham sanPham;
    public ChiTietPhieuNhapHang() {
    }
    public ChiTietPhieuNhapHang(Integer id, Double giaNhap, Integer soLuong) {
        this.id = id;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getGiaNhap() {
        return giaNhap;
    }
    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }
    public Integer getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
    public String getSeri() {
        return seri;
    }
    public void setSeri(String seri) {
        this.seri = seri;
    }
    public PhieuNhapHang getPhieuNhapHang() {
        return phieuNhapHang;
    }
    public void setPhieuNhapHang(PhieuNhapHang phieuNhapHang) {
        this.phieuNhapHang = phieuNhapHang;
    }
    public SanPham getSanPham() {
        return sanPham;
    }
    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    
    
}
