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
@Table(name = "don_dat_hang")
public class DonDatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "trang_thai")
    private Integer trangThai;
    @Column(name = "tong_tien")
    private Double tongTien;
    @Column(name = "trang_thai_thanh_toan")
    private Integer trangThaiThanhToan;
    @Column(name = "ten_khach_hang")
    private String tenKhachHang;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    @Column(name = "ghi_chu")
    private String ghiChu;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @OneToMany(mappedBy = "donDatHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietDonDatHang> chiTietDonDatHangs;
    @OneToMany(mappedBy = "donDatHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HoaDon> hoaDons;
    @JoinColumn(name = "customer", referencedColumnName = "id")
    @ManyToOne
    private Customer customer;
}
