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

@Entity
@Table(name = "tra_gop")
public class TraGop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "hoa_don_id", referencedColumnName = "id")
    @ManyToOne
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
    public TraGop() {
    }
    public TraGop(Integer id, HoaDon hoaDon, Double soTienHangThang, Boolean daBank, Date dongTienTuNgay,
            Date dongTienDenNgay, Date ngayDongTien) {
        this.id = id;
        this.hoaDon = hoaDon;
        this.soTienHangThang = soTienHangThang;
        this.daBank = daBank;
        this.dongTienTuNgay = dongTienTuNgay;
        this.dongTienDenNgay = dongTienDenNgay;
        this.ngayDongTien = ngayDongTien;
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
    
}
