package vn.edu.vlu.khoaluan.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dashboard")
public class DashBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer countUser;
    private Integer countDonHang;
    private Integer countSanPham;
    private Integer countLoaiSanPham;
    private Integer countKhuyenMai;
    private Integer countNhaCungCap;
    private Integer countNhaSanXuat;
    private Date dateCreate;
    private String trangThai;
    public DashBoard() {
    }
    
    public DashBoard(Integer countUser, Integer countDonHang, Integer countSanPham,
            Integer countLoaiSanPham, Integer countKhuyenMai, Integer countNhaCungCap, Integer countNhaSanXuat,
            Date dateCreate, String trangThai) {
        this.countUser = countUser;
        this.countDonHang = countDonHang;
        this.countSanPham = countSanPham;
        this.countLoaiSanPham = countLoaiSanPham;
        this.countKhuyenMai = countKhuyenMai;
        this.countNhaCungCap = countNhaCungCap;
        this.countNhaSanXuat = countNhaSanXuat;
        this.dateCreate = dateCreate;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCountUser() {
        return countUser;
    }
    public void setCountUser(Integer countUser) {
        this.countUser = countUser;
    }
    public Integer getCountDonHang() {
        return countDonHang;
    }
    public void setCountDonHang(Integer countDonHang) {
        this.countDonHang = countDonHang;
    }
    public Integer getCountSanPham() {
        return countSanPham;
    }
    public void setCountSanPham(Integer countSanPham) {
        this.countSanPham = countSanPham;
    }
    public Integer getCountLoaiSanPham() {
        return countLoaiSanPham;
    }
    public void setCountLoaiSanPham(Integer countLoaiSanPham) {
        this.countLoaiSanPham = countLoaiSanPham;
    }
    public Integer getCountKhuyenMai() {
        return countKhuyenMai;
    }
    public void setCountKhuyenMai(Integer countKhuyenMai) {
        this.countKhuyenMai = countKhuyenMai;
    }
    public Integer getCountNhaCungCap() {
        return countNhaCungCap;
    }
    public void setCountNhaCungCap(Integer countNhaCungCap) {
        this.countNhaCungCap = countNhaCungCap;
    }
    public Integer getCountNhaSanXuat() {
        return countNhaSanXuat;
    }
    public void setCountNhaSanXuat(Integer countNhaSanXuat) {
        this.countNhaSanXuat = countNhaSanXuat;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public Date getDateCreate() {
        return dateCreate;
    }
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
    
}
