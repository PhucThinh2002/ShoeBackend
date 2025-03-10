package vn.edu.vlu.khoaluan.model;

import java.util.List;

public class ModelPhieuNhapHang {
    private Double tongTien;
    private Integer nhaCungCap;
    private List<ChiTietPhieuNhapHang> chiTietPhieuNhapHang;
    public ModelPhieuNhapHang() {
    }
    public Double getTongTien() {
        return tongTien;
    }
    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
    public Integer getNhaCungCap() {
        return nhaCungCap;
    }
    public void setNhaCungCap(Integer nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    public List<ChiTietPhieuNhapHang> getChiTietPhieuNhapHang() {
        return chiTietPhieuNhapHang;
    }
    public void setChiTietPhieuNhapHang(List<ChiTietPhieuNhapHang> chiTietPhieuNhapHang) {
        this.chiTietPhieuNhapHang = chiTietPhieuNhapHang;
    }

}
