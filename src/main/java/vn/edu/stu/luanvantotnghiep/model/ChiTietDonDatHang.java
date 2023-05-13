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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "chi_tiet_don_dat_hang")
public class ChiTietDonDatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "so_luong")
    private Integer soLuong;
    @Column(name = "gia")
    private Double gia;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @JoinColumn(name = "san_pham", referencedColumnName = "id")
    @ManyToOne
    private SanPham sanPham;
    @JoinColumn(name = "donDatHang", referencedColumnName = "id")
    @ManyToOne
    private DonDatHang donDatHang;
}
