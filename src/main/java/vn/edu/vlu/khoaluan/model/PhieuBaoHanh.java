package vn.edu.vlu.khoaluan.model;
import java.util.Date;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="phieu_bao_hanh")
public class PhieuBaoHanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date ngayBatDauBaoHanh;
    private Date ngayHetBaoHanh;
    @JoinColumn(name = "quan_ly_id", referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    private HoaDon hoaDon;
    public PhieuBaoHanh() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getNgayBatDauBaoHanh() {
        return ngayBatDauBaoHanh;
    }
    public void setNgayBatDauBaoHanh(Date ngayBatDauBaoHanh) {
        this.ngayBatDauBaoHanh = ngayBatDauBaoHanh;
    }
    public Date getNgayHetBaoHanh() {
        return ngayHetBaoHanh;
    }
    public void setNgayHetBaoHanh(Date ngayHetBaoHanh) {
        this.ngayHetBaoHanh = ngayHetBaoHanh;
    }
    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
    
}
