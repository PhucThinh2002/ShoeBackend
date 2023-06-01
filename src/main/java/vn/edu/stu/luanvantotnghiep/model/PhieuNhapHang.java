package vn.edu.stu.luanvantotnghiep.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "phieu_nhap_hang")
public class PhieuNhapHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tong_tien")
    private Double tongTien;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @JoinColumn(name = "nha_cung_cap", referencedColumnName = "id")
    @ManyToOne
    private NhaCungCap nhaCungCap;
    @JoinColumn(name = "quan_ly_id", referencedColumnName = "id")
    @ManyToOne
    private Customer quanLy;
    @OneToMany(mappedBy = "phieuNhapHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietPhieuNhapHang> ChiTietPhieuNhapHang;
    public PhieuNhapHang() {
    }
    public PhieuNhapHang(Integer id, Double tongTien, Date createDate, Date updateDate) {
        this.id = id;
        this.tongTien = tongTien;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getTongTien() {
        return tongTien;
    }
    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
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
