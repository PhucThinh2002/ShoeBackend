package vn.edu.stu.luanvantotnghiep.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "customer")
public class Customer{
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
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
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
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DonDatHang> donDatHangs;

    public Customer() {
    }

    public Customer(Integer id, String hoTenLot, String ten, Date ngaySinh, String soDienThoai, String email,
            String diaChi, String username, String password, Date createdAt, Date updatedAt, Integer active,
            Province province, District district, Ward ward, Role role) {
        this.id = id;
        this.hoTenLot = hoTenLot;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public Date getCreatedAt() {
        return createdAt;
    }



    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getHoTenLot() {
        return hoTenLot;
    }

    public void setHoTenLot(String hoTenLot) {
        this.hoTenLot = hoTenLot;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    public Integer getActive() {
        return active;
    }



    public void setActive(Integer active) {
        this.active = active;
    }
    
}
