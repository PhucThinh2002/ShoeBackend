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
