package vn.edu.vlu.khoaluan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "thuoc_tinh")
public class ThuocTinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_thuoc_tinh", length = 50)
    private String tenThuocTinh;
    @Column(name = "gia_tri_thuoc_tinh", length = 50)
    private String giaTriThuocTinh;
    @Column(name = "loai", length = 1)
    private Integer loai;
    @JoinColumn(name = "san_pham_id", referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    private SanPham sanPham;
    public ThuocTinh() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTenThuocTinh() {
        return tenThuocTinh;
    }
    public void setTenThuocTinh(String tenThuocTinh) {
        this.tenThuocTinh = tenThuocTinh;
    }
    public String getGiaTriThuocTinh() {
        return giaTriThuocTinh;
    }
    public void setGiaTriThuocTinh(String giaTriThuocTinh) {
        this.giaTriThuocTinh = giaTriThuocTinh;
    }
    public Integer getLoai() {
        return loai;
    }
    public void setLoai(Integer loai) {
        this.loai = loai;
    }
    public SanPham getSanPham() {
        return sanPham;
    }
    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    
}
