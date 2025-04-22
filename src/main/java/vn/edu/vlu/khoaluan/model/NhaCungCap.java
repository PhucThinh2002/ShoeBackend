package vn.edu.vlu.khoaluan.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
@Entity
@Table(name = "nha_cung_cap")
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_nha_cung_cap", length = 100)
    private String tenNhaCungCap;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "email", length = 100)
    @Email
    private String email;
    @Column(name = "so_dien_thoai", length = 15)
    private String soDienThoai;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhieuNhapHang> phieuNhapHangs;
    @Column(name = "active", length = 1)
    private Integer active;
    public NhaCungCap() {
    }
    public NhaCungCap(Integer id, String tenNhaCungCap, String diaChi, @Email String email, String soDienThoai,
            Date createDate, Date updateDate) {
        this.id = id;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }
    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
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
    public void setPhieuNhapHangs(List<PhieuNhapHang> phieuNhapHangs) {
        this.phieuNhapHangs = phieuNhapHangs;
    }
    public Integer getActive() {
        return active;
    }
    public void setActive(Integer active) {
        this.active = active;
    }
    
    
}
