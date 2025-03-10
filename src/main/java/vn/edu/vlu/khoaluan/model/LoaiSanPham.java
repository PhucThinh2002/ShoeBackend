package vn.edu.vlu.khoaluan.model;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "danh_muc")
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_danh_muc", length = 100)
    private String tenDanhMuc;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "create_date")
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @OneToMany(mappedBy = "danhMuc", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<SanPham> sanPhams;
    @Column(name = "active", length = 1)
    private Integer active;
    @Transient
    private Integer countSP;
    public LoaiSanPham() {
    }
    public LoaiSanPham(Integer id, String tenDanhMuc, String moTa, Date createDate, Date updateDate,
            List<SanPham> sanPhams) {
        this.id = id;
        this.tenDanhMuc = tenDanhMuc;
        this.moTa = moTa;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.sanPhams = sanPhams;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTenDanhMuc() {
        return tenDanhMuc;
    }
    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
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
    public List<SanPham> getSanPhams() {
        return sanPhams;
    }
    public void setSanPhams(List<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }
    public Integer getActive() {
        return active;
    }
    public void setActive(Integer active) {
        this.active = active;
    }
    public Integer getCountSP() {
        return countSP;
    }
    public void setCountSP(Integer countSP) {
        this.countSP = countSP;
    }
    
    
}
