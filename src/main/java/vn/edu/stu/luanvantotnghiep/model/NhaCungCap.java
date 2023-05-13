package vn.edu.stu.luanvantotnghiep.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "nha_cung_cap")
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_nha_cung_cap")
    private String tenNhaCungCap;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "email")
    @Email
    private String email;
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhieuNhapHang> phieuNhapHangs;
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
    
}
