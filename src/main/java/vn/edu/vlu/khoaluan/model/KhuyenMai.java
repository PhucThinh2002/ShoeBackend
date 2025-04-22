package vn.edu.vlu.khoaluan.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "khuyen_mai")
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_khuyen_mai", length = 100)
    private String name;
    @Column(name = "phan_tram_khuyen_mai", length = 3)
    private Integer percentDiscount;
    @Column(name = "mo_ta")
    private String description;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @Column(name = "ngay_het_khuyen_mai")
    private Date closeDate;
    @Column(name = "trang_thai", length = 1)
    private Integer active;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "khuyenmai_sanpham", joinColumns = {@JoinColumn(name = "khuyen_mai_id")}, inverseJoinColumns = {@JoinColumn(name = "san_pham_id")})
    @JsonIgnore
    private List<SanPham> sanPham;
    public KhuyenMai() {
    }
    public KhuyenMai(Integer id, String name, Integer percentDiscount, String description) {
        this.id = id;
        this.name = name;
        this.percentDiscount = percentDiscount;
        this.description = description;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPercentDiscount() {
        return percentDiscount;
    }
    public void setPercentDiscount(Integer percentDiscount) {
        this.percentDiscount = percentDiscount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public Date getCloseDate() {
        return closeDate;
    }
    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }
    public List<SanPham> getSanPham() {
        return sanPham;
    }
    public void setSanPham(List<SanPham> sanPham) {
        this.sanPham = sanPham;
    }
    public Integer getActive() {
        return active;
    }
    public void setActive(Integer active) {
        this.active = active;
    }
    
    
}
