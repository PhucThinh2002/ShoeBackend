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
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "HO_TEN_LOT")
    private String hoTenLot;
    @Column(name = "TEN")
    private String ten;
    @Column(name = "NGAY_SINH")
    private Date ngaySinh;
    @Column(name = "SO_DIEN_THOAI")
    private String soDienThoai;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DIA_CHI")
    private String diaChi;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;
    @Column(name = "ACTIVE", length = 1)
    private Integer active;
    //@Column(name = "PROVINCE_ID")
    @ManyToOne
    @JoinColumn(name="province", nullable=false, insertable = true, updatable = true)
    private Province province;
    //@Column(name = "DISTRICT_ID")
    @ManyToOne
    @JoinColumn(name="district", nullable=false, insertable = true, updatable = true)
    private District district;
    //@Column(name = "WARD_ID")
    @ManyToOne
    @JoinColumn(name="ward", nullable=false, insertable = true, updatable = true)
    private Ward ward;
    @ManyToOne
    @JoinColumn(name="role", nullable=false, insertable = true, updatable = true)
    private Role role;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhieuNhapHang> phieuNhapHangs;
}
