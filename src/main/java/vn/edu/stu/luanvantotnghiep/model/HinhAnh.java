package vn.edu.stu.luanvantotnghiep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hinh_anh")
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_hinh_anh")
    private String tenHinhAnh;
    @Column(name = "kich_thuoc")
    private Integer kichThuoc;
    @Column(name = "path")
    private String path;
    @JoinColumn(name = "banner", referencedColumnName = "id")
    @ManyToOne
    private Banner banner;
    @JoinColumn(name = "sanPham", referencedColumnName = "id")
    @ManyToOne
    private SanPham sanPham;
}
