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

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bai_viet")
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tieu_de")
    private String tieuDe;
    @Column(name = "noi_dung")
    @Type(type = "text")
    private String noiDung;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @JoinColumn(name = "quan_ly_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Customer quanLy;
    @Column(name = "active", length = 1)
    private Integer active;
    public BaiViet() {
    }
    public BaiViet(Integer id, String tieuDe, String noiDung, Date createDate, Date updateDate, Customer quanLy) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.quanLy = quanLy;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTieuDe() {
        return tieuDe;
    }
    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    public String getNoiDung() {
        return noiDung;
    }
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
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
    public Customer getQuanLy() {
        return quanLy;
    }
    public void setQuanLy(Customer quanLy) {
        this.quanLy = quanLy;
    }
    public Integer getActive() {
        return active;
    }
    public void setActive(Integer active) {
        this.active = active;
    }
    
    
}
