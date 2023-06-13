package vn.edu.stu.luanvantotnghiep.model;

import java.util.Date;

public class ModelUser {
    private String hoTenLot;
    private String ten;
    private Date ngaySinh;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private String username;
    private String password;
    private Long province;
    private Long district;
    private Long ward;
    public ModelUser() {
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
    public Long getProvince() {
        return province;
    }
    public void setProvince(Long province) {
        this.province = province;
    }
    public Long getDistrict() {
        return district;
    }
    public void setDistrict(Long district) {
        this.district = district;
    }
    public Long getWard() {
        return ward;
    }
    public void setWard(Long ward) {
        this.ward = ward;
    }
    
}
