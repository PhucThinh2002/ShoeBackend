package vn.edu.stu.luanvantotnghiep.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_san_pham", length = 100)
    private String tenSanPham;
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HinhAnh> hinhAnhs;
    @Column(name = "gia")
    private double gia;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "trang_thai", length = 2)
    private Integer trangThai;
     @Column(name = "cpu")
    private String cpu;
     @Column(name = "ram")
    private String ram;
     @Column(name = "o_cung")
    private String oCung;
     @Column(name = "man_hinh")
    private String manHinh;
     @Column(name = "card_man_hinh")
    private String cardManHinh;
     @Column(name = "he_dieu_hanh")
    private String heDieuHanh;
     @Column(name = "thiet_ke")
    private String thietKe;
     @Column(name = "kich_thuoc_khoi_luong")
    private String kichThuocKhoiLuong;
     @Column(name = "nam_ra_mat")
    private String namRaMat;
    @Column(name = "so_luong_ton")
    private Integer soLuongTon;
    @Column(name = "bao_hanh", length = 100)
    private String baoHanh;
    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
    @JoinColumn(name = "danh_muc", referencedColumnName = "id")
    @ManyToOne
    private LoaiSanPham danhMuc;
    @JoinColumn(name = "nha_san_xuat", referencedColumnName = "id")
    @ManyToOne
    private NhaSanXuat nhaSanXuat;
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietPhieuNhapHang> chiTietPhieuNhapHang;
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietHoaDon> chiTietDonDatHangs;
    @ManyToMany(mappedBy = "sanPham")
    private List<KhuyenMai> khuyenMais;

}
