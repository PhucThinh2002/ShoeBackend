package vn.edu.stu.luanvantotnghiep.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tra_gop")
public class TraGop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "hoa_don_id", referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    private HoaDon hoaDon;
    @Column(name = "so_tien_hang_thang")
    private Double soTienHangThang;
    @Column(name = "da_bank")
    private Boolean daBank;
    @Column(name = "dong_tien_tu_ngay")
    private Date dongTienTuNgay;
    @Column(name = "dong_tien_den_ngay")
    private Date dongTienDenNgay;
    @Column(name = "ngay_dong_tien")
    private Date ngayDongTien;
    @Column(name = "phi_phat")
    private Double phiPhat;
    @Column(name = "trang_thai_phi_phat", length = 1)
    private Integer trangThaiPhiPhat = 0;
    public TraGop() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public HoaDon getHoaDon() {
        return hoaDon;
    }
    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
    public Double getSoTienHangThang() {
        return soTienHangThang;
    }
    public void setSoTienHangThang(Double soTienHangThang) {
        this.soTienHangThang = soTienHangThang;
    }
    public Boolean getDaBank() {
        return daBank;
    }
    public void setDaBank(Boolean daBank) {
        this.daBank = daBank;
    }
    public Date getDongTienTuNgay() {
        return dongTienTuNgay;
    }
    public void setDongTienTuNgay(Date dongTienTuNgay) {
        this.dongTienTuNgay = dongTienTuNgay;
    }
    public Date getDongTienDenNgay() {
        return dongTienDenNgay;
    }
    public void setDongTienDenNgay(Date dongTienDenNgay) {
        this.dongTienDenNgay = dongTienDenNgay;
    }
    public Date getNgayDongTien() {
        return ngayDongTien;
    }
    public void setNgayDongTien(Date ngayDongTien) {
        this.ngayDongTien = ngayDongTien;
    }
    public Double getPhiPhat() {
        return phiPhat;
    }
    public void setPhiPhat(Double phiPhat) {
        this.phiPhat = phiPhat;
    }
    public Integer getTrangThaiPhiPhat() {
        return trangThaiPhiPhat;
    }
    public void setTrangThaiPhiPhat(Integer trangThaiPhiPhat) {
        this.trangThaiPhiPhat = trangThaiPhiPhat;
    }
    
}
