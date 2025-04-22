package vn.edu.vlu.khoaluan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



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
    private PhieuNhapHang phieuNhapHang;
    @JoinColumn(name = "san_pham_id", referencedColumnName = "id")
    @ManyToOne
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
