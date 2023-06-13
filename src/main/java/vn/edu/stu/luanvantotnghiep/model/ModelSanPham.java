package vn.edu.stu.luanvantotnghiep.model;

import java.util.List;

public class ModelSanPham {
    private String tenSanPham;
    private double gia;
    private String moTa;
    private String namRaMat;
    private Integer soLuongTon;
    private String baoHanh;
    private LoaiSanPham danhMuc;
    private NhaSanXuat nhaSanXuat;
    private List<ThuocTinh> thuocTinhs;
    public ModelSanPham() {
    }
    public String getTenSanPham() {
        return tenSanPham;
    }
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    public double getGia() {
        return gia;
    }
    public void setGia(double gia) {
        this.gia = gia;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public String getNamRaMat() {
        return namRaMat;
    }
    public void setNamRaMat(String namRaMat) {
        this.namRaMat = namRaMat;
    }
    public Integer getSoLuongTon() {
        return soLuongTon;
    }
    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }
    public String getBaoHanh() {
        return baoHanh;
    }
    public void setBaoHanh(String baoHanh) {
        this.baoHanh = baoHanh;
    }
    public LoaiSanPham getDanhMuc() {
        return danhMuc;
    }
    public void setDanhMuc(LoaiSanPham danhMuc) {
        this.danhMuc = danhMuc;
    }
    public NhaSanXuat getNhaSanXuat() {
        return nhaSanXuat;
    }
    public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
    public List<ThuocTinh> getThuocTinhs() {
        return thuocTinhs;
    }
    public void setThuocTinhs(List<ThuocTinh> thuocTinhs) {
        this.thuocTinhs = thuocTinhs;
    }
    
}
