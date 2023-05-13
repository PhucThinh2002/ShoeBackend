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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "nha_san_xuat")
public class NhaSanXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_nha_san_xuat")
    private String tenNhaSanXuat;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @OneToMany(mappedBy = "nhaSanXuat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SanPham> sanPhams;
    public NhaSanXuat() {
    }
    public NhaSanXuat(Integer id, String tenNhaSanXuat, String moTa, Date createDate, Date updateDate) {
        this.id = id;
        this.tenNhaSanXuat = tenNhaSanXuat;
        this.moTa = moTa;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTenNhaSanXuat() {
        return tenNhaSanXuat;
    }
    public void setTenNhaSanXuat(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
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
