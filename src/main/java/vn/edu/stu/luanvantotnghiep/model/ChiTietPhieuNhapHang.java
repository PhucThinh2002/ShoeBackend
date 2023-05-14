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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @JoinColumn(name = "phieu_nhap_hang", referencedColumnName = "id")
    @ManyToOne
    private PhieuNhapHang phieuNhapHang;
    @JoinColumn(name = "san_pham", referencedColumnName = "id")
    @ManyToOne
    private SanPham sanPham;
    public ChiTietPhieuNhapHang() {
    }
    public ChiTietPhieuNhapHang(Integer id, Double giaNhap, Integer soLuong, Date createDate, Date updateDate) {
        this.id = id;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
        this.createDate = createDate;
        this.updateDate = updateDate;
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
    
}
