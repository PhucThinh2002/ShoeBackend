package vn.edu.vlu.khoaluan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hinh_anh")
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_hinh_anh")
    private String tenHinhAnh;
    @Column(name = "kich_thuoc")
    private Long kichThuoc;
    @Column(name = "path")
    private String path;
    @JoinColumn(name = "banner_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Banner banner;
    @JoinColumn(name = "san_pham_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private SanPham sanPham;
    public HinhAnh() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTenHinhAnh() {
        return tenHinhAnh;
    }
    public void setTenHinhAnh(String tenHinhAnh) {
        this.tenHinhAnh = tenHinhAnh;
    }
    public Long getKichThuoc() {
        return kichThuoc;
    }
    public void setKichThuoc(Long kichThuoc) {
        this.kichThuoc = kichThuoc;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public void setBanner(Banner banner) {
        this.banner = banner;
    }
    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    
}
