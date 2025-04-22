package vn.edu.vlu.khoaluan.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bai_viet")
@EntityListeners(AuditingEntityListener.class)
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "tieu_de", nullable = false)
    private String tieuDe;
    
    @Lob
    @Column(name = "noi_dung", nullable = false)
    private String noiDung;
    
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", updatable = false)
    private Date createDate;
    
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;
    
    @ManyToOne
    @JoinColumn(name = "quan_ly_id", referencedColumnName = "id")
    @JsonIgnore
    private Customer quanLy;
    
    @Column(name = "active", length = 1)
    private Integer active = 1; // Default value

    // Constructors
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

    // Getters and Setters
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