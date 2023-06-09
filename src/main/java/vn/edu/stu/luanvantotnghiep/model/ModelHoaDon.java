package vn.edu.stu.luanvantotnghiep.model;

import java.util.List;

public class ModelHoaDon {
    private String tenKhachHang;
    private String diaChi;
    private String soDienThoai;
    private String ghiChu;
    private Integer trangThaiThanhToan;
    private Integer soThangTraGop;
    private Double soTienTraTruoc;
    private Double soTienTraGop;
    private List<ChiTietHoaDon> chiTietHoaDons;
    public ModelHoaDon() {
    }
    public String getTenKhachHang() {
        return tenKhachHang;
    }
    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public String getGhiChu() {
        return ghiChu;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    public Integer getSoThangTraGop() {
        return soThangTraGop;
    }
    public void setSoThangTraGop(Integer soThangTraGop) {
        this.soThangTraGop = soThangTraGop;
    }
    public List<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }
    public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }
    public Integer getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }
    public void setTrangThaiThanhToan(Integer trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }
    public Double getSoTienTraTruoc() {
        return soTienTraTruoc;
    }
    public void setSoTienTraTruoc(Double soTienTraTruoc) {
        this.soTienTraTruoc = soTienTraTruoc;
    }
    public Double getSoTienTraGop() {
        return soTienTraGop;
    }
    public void setSoTienTraGop(Double soTienTraGop) {
        this.soTienTraGop = soTienTraGop;
    }
    
    
}
